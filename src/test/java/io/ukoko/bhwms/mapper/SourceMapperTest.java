package io.ukoko.bhwms.mapper;

import io.ukoko.bhwms.BhWmsApplicationTests;
import io.ukoko.bhwms.entity.Source;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;


class SourceMapperTest extends BhWmsApplicationTests {
    @Autowired
    private SourceMapper sourceMapper;

    @Test
    void addSource() {
        for (int i = 0; i < 100; i++) {
            Source source = new Source();
            source.setSourceName("来源名称"+i);
            source.setIsDelete(1);
            source.setCreateTime(new Date());
            sourceMapper.addSource(source);

        }
    }

    @Test
    void getSourceList() {
        sourceMapper.getSourceList().forEach(System.out::println);
    }
}