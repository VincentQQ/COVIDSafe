package com.magic;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class COVIDSafeApplication {

    public static void main(String[] args) {
        SpringApplication.run(COVIDSafeApplication.class, args);
    }
}



