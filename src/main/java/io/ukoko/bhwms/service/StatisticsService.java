package io.ukoko.bhwms.service;

import io.ukoko.bhwms.entity.Statistics;

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

}
