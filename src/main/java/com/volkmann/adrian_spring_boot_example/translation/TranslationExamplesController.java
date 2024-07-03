package com.volkmann.adrian_spring_boot_example.translation;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TranslationExamplesController {

	@Autowired
	ResourceBundleMessageSource messageSource;

	// basta enviar "Accept-Language" com "en-US" que ja faz a traducao
	@PostMapping(value = "/hello")
	public String helloWorld(Locale locale) throws Exception { // testar esse trowhs exceptions

		System.out.println("Default Locale= " + Locale.getDefault());
		System.out.println("endpoint locale= " + locale);

		return messageSource.getMessage("helloworld", null, locale);
	}

}
