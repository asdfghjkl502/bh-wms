package io.ukoko.bhwms.mapper;

import io.ukoko.bhwms.BhWmsApplicationTests;
import io.ukoko.bhwms.entity.RecordIn;
import io.ukoko.bhwms.entity.Statistics;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RecordInMapperTest extends BhWmsApplicationTests {


    @Resource
    private RecordInMapper recordInMapper;

    @Test
    void addRecordIn() {
        for (int i = 0; i < 100; i++) {
            RecordIn recordIn = new RecordIn();
            recordIn.setSupplierId(1);
            recordIn.setProductId(1);
            recordIn.setRecordInNumber(i+1);
            recordIn.setRecordInTime(new Date());
            recordIn.setUserId(1);
            recordIn.setRepoId(1);
            recordIn.setCreateTime(new Date());
            recordIn.setIsDelete(1);
            recordInMapper.addRecordIn(recordIn);
        }
    }

    @Test
    public void getStatisticsInMonth(){
        List<Statistics> statistics = recordInMapper.getStatisticsInMonth();
        for (Statistics statistic : statistics) {
            System.out.println(statistic);
        }
    }
}