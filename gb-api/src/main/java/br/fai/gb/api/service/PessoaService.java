package br.fai.gb.api.service;

import java.util.List;

import br.fai.gb.model.Pessoa;

public interface PessoaService {

	List<Pessoa> readAll();

	Pessoa readById(Long id);

	Long create(Pessoa pessoa);

	boolean update(Pessoa pessoa);

	boolean delete(Long id);

}
