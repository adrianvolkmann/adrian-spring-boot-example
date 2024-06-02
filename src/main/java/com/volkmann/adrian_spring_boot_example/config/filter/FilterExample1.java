package com.volkmann.adrian_spring_boot_example.config.filter;

import java.io.IOException;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletResponse;

@Component
//verificar @Webfilter
@Order(1) //possivel definir ordem que os Filters executarao
public class FilterExample1 implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		//util para tratar problemas de CORS
		HttpServletResponse resp = (HttpServletResponse) response;
		resp.addHeader("FilterExample1", "valor1");

		//necessario fazer essa chamada para continuar o fluxo
		chain.doFilter(request, response);
	}

}
