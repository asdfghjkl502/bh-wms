package io.ukoko.bhwms.controller;

import io.swagger.annotations.Api;
import io.ukoko.bhwms.dto.Result;
import io.ukoko.bhwms.entity.Statistics;
import io.ukoko.bhwms.service.RepositoryService;
import io.ukoko.bhwms.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(tags = "商业智能模块")
@CrossOrigin
@RestController
public class StatisticsController {

    @Autowired
    private StatisticsService statisticsService;

    @Autowired
    private RepositoryService repositoryService;


    /**
     * 统计12个月内的入库数量
     */
    @GetMapping(value = "/getStatisticsInMonth")
    public Object getStatisticsInMonth(){
        Map<String, Object> statistics = statisticsService.getStatisticsInMonth();
        return new Result(statistics);
    }

    /**
     * 统计12个月内的出库数量
     */
    @GetMapping(value = "/getStatisticsOutMonth")
    public Object getStatisticsOutMonth(){
        Map<String, Object> statistics = statisticsService.getStatisticsOutMonth();
        return new Result(statistics);
    }

    /**
     * 统计12个月内的出入库金额
     */
    @GetMapping(value = "/getStatisticsMonthMoney")
    public Object getStatisticsMonthMoney() throws ParseException {
        Map<String, Object> monthMoney = statisticsService.getStatisticsMonthMoney();
        return new Result(monthMoney);
    }

    /**
     * 仓库负载统计
     */
    @GetMapping(value = "/getRepositoryPayloadStatistics")
    public Object getRepositoryPayloadStatistics(){
        List<Statistics> payloadStatistics = repositoryService.getRepositoryPayloadStatistics();

        List<Map<String,Object>> ss = new ArrayList<>();
        for (Statistics ps : payloadStatistics) {
            Map<String,Object> map = new HashMap<>();
            map.put("name",ps.getCommon());
            map.put("value",ps.getCount());
            ss.add(map);
        }
        return new Result(ss);
    }

    /**
     * 当前库存
     */
    /**
     * 当天出库
     */
    /**
     * 当天入库
     */
}
