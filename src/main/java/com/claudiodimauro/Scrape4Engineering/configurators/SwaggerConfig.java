package com.claudiodimauro.Scrape4Engineering.configurators;

import com.google.common.base.Predicates;
import java.util.Collections;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        //Return a prepared Docket instance
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                //.paths(PathSelectors.ant("/api/*/*"))
                .paths(Predicates.not(PathSelectors.regex("/error.*")))
                .apis(RequestHandlerSelectors.basePackage("com.claudiodimauro.Scraper4Engineering.api"))
                .build()
                .apiInfo(apiDetails());

    }

    private ApiInfo apiDetails() {
        return new ApiInfo(
                "Adress scrape API",
                "API for scrape",
                "1.1",
                "Free to use",
                new springfox.documentation.service.Contact("Pierpaolo Venanzio", "https://web.unisa.it", "aidç@.com"),
                "Api license",
                "https://web.unisa.it",
                Collections.emptyList());
    }
}
