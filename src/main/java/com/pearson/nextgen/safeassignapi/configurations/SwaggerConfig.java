package com.pearson.nextgen.safeassignapi.configurations;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static org.springframework.web.servlet.mvc.method.RequestMappingInfo.paths;

@Configuration
@EnableSwagger2           //enable the swagger configuration during application startup.
public class SwaggerConfig {

    @Bean
    public Docket produceApi(){     //Docket - builder which acts as a primary interface in swagger-springmvc framework
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.pearson.nextgen.safeassignapi.controllers"))
                .paths(paths())
                .build();
    }
    // Describe your apis
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Safe Assign Rest API")
                .description("This page lists all the rest api for Safe Assign.")
                .version("1.0-SNAPSHOT")
                .build();
    }

    // Only select apis that matches the given Predicates.
    private Predicate<String> paths() {
    // Match all paths except /error
        return Predicates.and(
                PathSelectors.regex("/person.*"),
                Predicates.not(PathSelectors.regex("/error.*")));
    }
}
