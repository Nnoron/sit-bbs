package com.local.i_sit_bbs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@MapperScan(basePackages={"com.local.i_sit_bbs.dao."})
@SpringBootApplication
public class ISitBbsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ISitBbsApplication.class, args);
    }

}
