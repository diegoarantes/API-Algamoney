package com.algamoneyapi.config.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@ConfigurationProperties("algamoney")
public class AlgamoneyApiProperty {
	
	@Getter @Setter
	private String originPermitida = "http://localhost:8000";
	
	@Getter
	private final Seguranca seguranca = new Seguranca();

	@Data
	public static class Seguranca {
		private boolean enableHttps;
	}
}
