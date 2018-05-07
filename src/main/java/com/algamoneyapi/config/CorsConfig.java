package com.algamoneyapi.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/***
 * 
 * @author D.Arantes
 * Esta configuração substitui a aula '6.10. Criando filtro para CORS'
 * TODO: Caso não funcione com o Oauth devo implementar um filtro como descrito na aula
 */
@Configuration
public class CorsConfig {
	
	private String originPermitida = "http://localhost:8000"; // TODO: Configurar para diferentes ambientes

	@Bean
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public FilterRegistrationBean corsFilterRegistrationBean() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.addAllowedOrigin(this.originPermitida);
		
		//config.addAllowedHeader("*");
		config.addAllowedHeader("Authorization");
		config.addAllowedHeader("Content-Type");
		config.addAllowedHeader("Accept");
		
		//config.addAllowedMethod("*");
		config.addAllowedMethod("POST");
		config.addAllowedMethod("GET");
		config.addAllowedMethod("DELETE");
		config.addAllowedMethod("PUT");
		config.addAllowedMethod("OPTIONS");
		
		config.setMaxAge(3600L);
		source.registerCorsConfiguration("/**", config);

		FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return bean;
	}
}
