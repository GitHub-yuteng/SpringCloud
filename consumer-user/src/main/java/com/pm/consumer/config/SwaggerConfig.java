package com.pm.consumer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Yu
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(true)
                .groupName("服务消费者")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.pm.consumer.controller")).build();

    }

    public ApiInfo apiInfo() {
        Contact contact = new Contact("YT", "http://localhost:8080", "soft_yt@163.com");
        return new ApiInfoBuilder()
                .title("Swagger接口文档")
                .description("Consumer模块")
                .version("version 1.0.0")
                .contact(contact)
                .build();
    }
}
