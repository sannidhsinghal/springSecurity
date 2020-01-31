package com.sannidh.practice.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModuleMapperConfig {

    @Bean
    public ModelMapper moduleMapper() {
        return new ModelMapper();
    }

}