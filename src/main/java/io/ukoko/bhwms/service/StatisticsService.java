package io.ukoko.bhwms.service;

import io.ukoko.bhwms.entity.Statistics;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

/**
 * 商业智能模块的业务逻辑层
 */
public interface StatisticsService {
    /**
     * 统计12个月的入库量
     */
    Map<String,Object> getStatisticsInMonth();
    /**
     * 统计12个月的出库量
     */
    Map<String,Object> getStatisticsOutMonth();

    /**
     * 统计12个月出入库产品金额数量
     */
    Map<String,Object> getStatisticsMonthMoney() throws ParseException;
}
