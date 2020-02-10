package com.sannidh.practice.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiKey
import springfox.documentation.service.AuthorizationScope
import springfox.documentation.service.SecurityReference
import springfox.documentation.service.SecurityScheme
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spi.service.contexts.SecurityContext
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@Configuration
@EnableSwagger2
class SwaggerConfig {
    @Bean
    Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.regex("/api/practice/facade.*"))
                .build()
                .securitySchemes(Arrays.asList(bearerToken()))
                .securityContexts(Arrays.asList(securityContext()))
                .ignoredParameterTypes(MetaClass.class)
    }


    private SecurityScheme bearerToken(){
        return new ApiKey("Authorization-Key","Authorization","header")
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(Arrays.asList(defaultAuth()))
                .forPaths(PathSelectors.ant("/api/practice/facade/**"))
                .build()
    }

    private SecurityReference defaultAuth() {
        return new SecurityReference("Authorization-Key", new AuthorizationScope[0]);
    }
}