package io.ukoko.bhwms.mapper;

import io.ukoko.bhwms.BhWmsApplicationTests;
import io.ukoko.bhwms.entity.RecordOut;
import io.ukoko.bhwms.entity.Statistics;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RecordOutMapperTest extends BhWmsApplicationTests {

    @Autowired
    private RecordOutMapper recordOutMapper;

    @Test
    void addRecordOut() {
        for (int i = 0; i < 100; i++) {
            RecordOut recordOut = new RecordOut();
            recordOut.setCustomerId(1);
            recordOut.setProductId(1);
            recordOut.setRecordOutNumber(i+1);
            recordOut.setRecordOutTime(new Date());
            recordOut.setUserId(1);
            recordOut.setRepoId(1);
            recordOut.setCreateTime(new Date());
            recordOut.setIsDelete(1);
            recordOutMapper.addRecordOut(recordOut);
        }
    }

    @Test
    void getStatisticsOutMonth() {

        List<Statistics> statistics = recordOutMapper.getStatisticsOutMonth();
        for (Statistics statistic : statistics) {
            System.out.println(statistic);
        }
    }
}