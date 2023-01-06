package io.ukoko.bhwms.service;

import io.ukoko.bhwms.BhWmsApplicationTests;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;

import java.text.ParseException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class StatisticsServiceTest extends BhWmsApplicationTests {

    @Resource
    private StatisticsService statisticsService;

    @Test
    void getStatisticsMonthMoney() throws ParseException {
        Map<String, Object> map = statisticsService.getStatisticsMonthMoney();
        System.out.println(map);
    }

}