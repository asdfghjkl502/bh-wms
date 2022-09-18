package io.ukoko.bhwms.mapper;

import io.ukoko.bhwms.BhWmsApplicationTests;
import io.ukoko.bhwms.entity.Industry;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class IndustryMapperTest extends BhWmsApplicationTests {

    @Autowired
    private IndustryMapper industryMapper;

    @Test
    void addIndustry() {
        for (int i = 0; i < 100; i++) {

            Industry industry = new Industry();
            industry.setIndustryName("来源名称"+i);
            industry.setCreateTime(new Date());
            industry.setIsDelete(i%2==0?1:0);
            industryMapper.addIndustry(industry);
        }
    }

    @Test
    void getIndustryList() {
        industryMapper.getIndustryList().forEach(System.out::println);
    }
}