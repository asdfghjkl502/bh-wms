package io.ukoko.bhwms;

import org.junit.jupiter.api.Test;
import org.lionsoul.ip2region.xdb.Searcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.File;
import java.io.IOException;
import java.net.URL;

@SpringBootTest
public class BhWmsApplicationTests {

    @Autowired
    private ResourceLoader resourceLoader;

    @Test
    void contextLoads() throws Exception {

        Resource resource = resourceLoader.getResource("xdb/ip2region.xdb");
        String path = resource.getFile().getPath();
        Searcher searcher = Searcher.newWithFileOnly(path);
        String ip = "1.2.3.4";
        String region = searcher.searchByStr(ip);
        System.out.println(region);
    }
}
