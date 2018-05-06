package com.algamoneyapi.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algamoneyapi.model.Pessoa;
import com.algamoneyapi.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;

	public Pessoa atualizar(Long codigo, Pessoa pessoa) {
		Optional<Pessoa> pessoaSalva = buscarPessoaPeloCodigo(codigo);

		BeanUtils.copyProperties(pessoa, pessoaSalva.get(), "codigo");

		return pessoaRepository.save(pessoaSalva.get());
	}

	public void atualizarPropriedadeAtivo(Long codigo, Boolean ativo) {
		Optional<Pessoa> pessoaSalva = buscarPessoaPeloCodigo(codigo);
		pessoaSalva.get().setAtivo(ativo);

		pessoaRepository.save(pessoaSalva.get());
	}

	private Optional<Pessoa> buscarPessoaPeloCodigo(Long codigo) {
		Optional<Pessoa> pessoaSalva = pessoaRepository.findById(codigo);

		if (!pessoaSalva.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		return pessoaSalva;
	}

}
