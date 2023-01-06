package io.ukoko.bhwms.service.impl;

import io.ukoko.bhwms.entity.Statistics;
import io.ukoko.bhwms.mapper.RecordInMapper;
import io.ukoko.bhwms.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional
@Service
public class StatisticsServiceImpl implements StatisticsService {

    @Autowired
    private RecordInMapper recordInMapper;


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
}
