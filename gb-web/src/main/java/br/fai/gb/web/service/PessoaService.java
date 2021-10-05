package br.fai.gb.web.service;

import java.util.List;

import br.fai.gb.model.Pessoa;

public interface PessoaService {

	List<Pessoa> readAll();

	Long create(Pessoa pessoa);

	Pessoa readById(Long id);

	boolean update(Pessoa pessoa);

	boolean deleteById(Long id);

}
