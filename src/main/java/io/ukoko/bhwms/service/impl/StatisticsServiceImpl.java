package io.ukoko.bhwms.service.impl;

import io.ukoko.bhwms.entity.Product;
import io.ukoko.bhwms.entity.Statistics;
import io.ukoko.bhwms.mapper.ProductMapper;
import io.ukoko.bhwms.mapper.RecordInMapper;
import io.ukoko.bhwms.mapper.RecordOutMapper;
import io.ukoko.bhwms.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Transactional
@Service
public class StatisticsServiceImpl implements StatisticsService {

    @Autowired
    private RecordInMapper recordInMapper;
    @Autowired
    private RecordOutMapper recordOutMapper;
    @Autowired
    private ProductMapper productMapper;


    @Override
    public Map<String, Object> getStatisticsInMonth() {
        List<Statistics> statistics = recordInMapper.getStatisticsInMonth();
        List<Long> counts = new ArrayList<>();
        List<String> times = new ArrayList<>();
        for (Statistics statistic : statistics) {
            counts.add(statistic.getCount());
            times.add(statistic.getTime());
        }
        Map<String, Object> map = new HashMap<>();
        map.put("counts",counts);
        map.put("times",times);
        return map;
    }

    @Override
    public Map<String, Object> getStatisticsOutMonth() {
        List<Statistics> statistics = recordOutMapper.getStatisticsOutMonth();
        List<Long> counts = new ArrayList<>();
        List<String> times = new ArrayList<>();
        for (Statistics statistic : statistics) {
            counts.add(statistic.getCount());
            times.add(statistic.getTime());
        }
        Map<String, Object> map = new HashMap<>();
        map.put("counts",counts);
        map.put("times",times);
        return map;
    }

    @Override
    public Map<String, Object> getStatisticsMonthMoney() throws ParseException {

        Map<String, Object> mapInOutTimePrice = new HashMap<>();

        //获取时间(12个月)
        List<Statistics> statistics = recordOutMapper.getStatisticsOutMonth();
        List<String> times = new ArrayList<>();
        for (Statistics statistic : statistics) {
            times.add(statistic.getTime());
        }

        //讲时间保存到map中
        mapInOutTimePrice.put("times",times);

        //时间格式化
        List<Map<String,Date>> timeStartEnd = new ArrayList<>();
        for (String time : times) {
            if (time == null || !time.contains("-")) {
                continue;
            }
            //获取月份
            String[] split = time.split("-");
            if (split.length < 2) {
                continue;
            }
            Map<String,Date> mse = new HashMap<>();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            switch (split[1]){
                case "01":
                case "03":
                case "05":
                case "07":
                case "08":
                case "10":
                case "12":
                    //开始时间
                    String s1 =  time+"-01 00:00:00";
                    //结束时间
                    String e1 =  time+"-31 23:59:59";
                    mse.put("startTime",sdf.parse(s1));
                    mse.put("endTime",sdf.parse(e1));
                    timeStartEnd.add(mse);
                    break;
                case "02":
                    /*闰年/平年*/
                    //当前年份
                    int year;
                    try {
                        year = Integer.parseInt(split[0]);
                    } catch (NumberFormatException e) {
                        continue;
                    }
                    if(year%400==0 || (year%4==0 && year%100!=0)){
                        //闰年 29号
                        //开始时间
                        String s3 =  time+"-01 00:00:00";
                        //结束时间
                        String e3 =  time+"-29 23:59:59";
                        mse.put("startTime",sdf.parse(s3));
                        mse.put("endTime",sdf.parse(e3));
                        timeStartEnd.add(mse);
                    }else{
                        //平年 28号
                        //开始时间
                        String s3 =  time+"-01 00:00:00";
                        //结束时间
                        String e3 =  time+"-28 23:59:59";
                        mse.put("startTime",sdf.parse(s3));
                        mse.put("endTime",sdf.parse(e3));
                        timeStartEnd.add(mse);
                    }
                    break;
                case "04":
                case "06":
                case "09":
                case "11":
                    //开始时间
                    String s2 =  time+"-01 00:00:00";
                    //结束时间
                    String e2 =  time+"-30 23:59:59";
                    mse.put("startTime",sdf.parse(s2));
                    mse.put("endTime",sdf.parse(e2));
                    timeStartEnd.add(mse);
                    break;
            }
        }
        //装每一个月入库商品总价
        List<Double> recordInPrice = new ArrayList<>();
        //装每一个月出库商品总价
        List<Double> recordOutPrice = new ArrayList<>();
        //通过时间查询入库金额
        for (Map<String, Date> stringDateMap : timeStartEnd) {
            Double totalInPrice=0d;//当前月份入库商品总价
            Double totalOutPrice=0d;//当前月份出库商品总价
            //通过时间查询入库商品以及商品对应的数量
            List<Statistics> recordInProductCount = recordInMapper.getStatisticsInByTime(stringDateMap.get("startTime"), stringDateMap.get("endTime"));
            for (Statistics sc : recordInProductCount) {
                //通过商品ID获取商品价格
                Product product = productMapper.getProductByProductId(sc.getProductId());
                if (product == null) {
                    continue;
                }
                //当前商品数量
                Long count = sc.getCount();
                //当前商品总价
                Double t = product.getProductPrice()*count;
                //总价
                totalInPrice+=t;
            }
            recordInPrice.add(totalInPrice);
            //通过时间查询出库金额
            List<Statistics> recordOutProductCount = recordOutMapper.getStatisticsOutByTime(stringDateMap.get("startTime"), stringDateMap.get("endTime"));
            for (Statistics sco : recordOutProductCount) {
                //通过商品ID获取商品价格
                Product product = productMapper.getProductByProductId(sco.getProductId());
                if (product == null) {
                    continue;
                }
                //当前商品数量
                Long count = sco.getCount();
                //当前商品总价
                Double t = product.getProductPrice()*count;
                //总价
                totalOutPrice+=t;
            }
            recordOutPrice.add(totalOutPrice);
        }
        //将入库金额保存到map中
        mapInOutTimePrice.put("recordInPrice",recordInPrice);
        //将入出库金额保存到map中
        mapInOutTimePrice.put("recordOutPrice",recordOutPrice);
        return mapInOutTimePrice;
    }
}
