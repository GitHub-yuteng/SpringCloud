package com.pm.providerticket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

//@SpringBootApplication(exclude = {DruidDataSourceAutoConfigure.class})
@SpringBootApplication()
@MapperScan("com.pm.providerticket.mapper")
public class ProviderTicketApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderTicketApplication.class, args);
    }

}

