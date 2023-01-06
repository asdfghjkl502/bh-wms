package io.ukoko.bhwms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class BhWmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(BhWmsApplication.class, args);
    }

}
