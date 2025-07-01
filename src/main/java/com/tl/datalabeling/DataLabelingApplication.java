package com.tl.datalabeling;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@MapperScan("com.tl.datalabeling.mapper")
@EnableFeignClients
public class DataLabelingApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataLabelingApplication.class, args);
    }

}
