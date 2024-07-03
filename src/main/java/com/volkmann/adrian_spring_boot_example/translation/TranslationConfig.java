package com.volkmann.adrian_spring_boot_example.translation;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class TranslationConfig {

	@Bean
	MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("translations/messages");
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}

}
