package com.algamoneyapi.repository.lancamento;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.algamoneyapi.model.Lancamento;
import com.algamoneyapi.repository.filter.LancamentoFilter;

public interface LancamentoRepositoryQuery {
	public Page<Lancamento> filtrar(LancamentoFilter lancamentoFilter, Pageable page);
}
