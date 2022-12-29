package io.ukoko.bhwms;

import org.junit.jupiter.api.Test;
import org.lionsoul.ip2region.xdb.Searcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

@SpringBootTest
public class BhWmsApplicationTests {


    @Test
    public void test01() throws UnsupportedEncodingException {

        String s="admin";

        //编码
        String encode = Base64.getEncoder().encodeToString(s.getBytes());
        System.out.println(encode); //YWRtaW4=
        //解码
        byte[] decode = Base64.getDecoder().decode("YWRtaW4=");
        System.out.println(new String(decode,"UTF-8"));

    }

}
