package com.crud.spring.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @project: demo
 * @author: rsaldanar
 * @date: 28/9/22
 * @Correo: rsaldanar@gmail.com
 * @description:
 * @history:
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public static Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.crud.spring.demo.controller"))
                .paths(PathSelectors.any())
                .build();
    }
}
