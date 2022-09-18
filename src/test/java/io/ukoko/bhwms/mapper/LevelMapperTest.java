package io.ukoko.bhwms.mapper;

import io.ukoko.bhwms.BhWmsApplicationTests;
import io.ukoko.bhwms.entity.Level;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class LevelMapperTest extends BhWmsApplicationTests {
    @Autowired
    private LevelMapper levelMapper;

    @Test
    void addLevel() {

        for (int i = 0; i < 100; i++) {

            Level level = new Level();
            level.setLevelName("级别"+i);
            level.setCreateTime(new Date());
            level.setIsDelete(i%2==0?1:0);
            levelMapper.addLevel(level);
        }
        
    }

    @Test
    void getLevelList() {
    }
}