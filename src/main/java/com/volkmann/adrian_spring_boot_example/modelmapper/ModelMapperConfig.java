package com.volkmann.adrian_spring_boot_example.modelmapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    ModelMapper modelMapper() {
		//onde configurar as customizzacoes dos mapperrs
		return new ModelMapper();
	}
	
}
