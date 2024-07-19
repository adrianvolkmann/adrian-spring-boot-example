package com.volkmann.adrian_spring_boot_example.modelmapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //annotation indicates that the class will be used by JavaConfig as a source of bean definitions.
public class ModelMapperConfig {

    @Bean
    ModelMapper modelMapper() {
		//onde configurar as customizzacoes dos mapperrs
		return new ModelMapper();
	}
	
}
