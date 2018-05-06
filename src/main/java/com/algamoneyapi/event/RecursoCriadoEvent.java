package com.algamoneyapi.event;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationEvent;

import lombok.Getter;

public class RecursoCriadoEvent extends ApplicationEvent {

	private static final long serialVersionUID = 1L;
	
	@Getter
	private Long codigo;
	
	@Getter
	private HttpServletResponse response;

	public RecursoCriadoEvent(Object source, Long codigo, HttpServletResponse response) {
		super(source);
		this.codigo = codigo;
		this.response = response;
	}
}
