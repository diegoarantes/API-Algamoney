package com.algamoneyapi.repository.projection;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.algamoneyapi.model.TipoLancamento;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor // Costrutor com todos os campos
public class ResumoLancamento {
	private Long codigo;
	private String descricao;
	private LocalDate dataVencimento;
	private LocalDate dataPagamento;
	private BigDecimal valor;
	private TipoLancamento tipo;
	private String categoria;
	private String pessoa;
}
