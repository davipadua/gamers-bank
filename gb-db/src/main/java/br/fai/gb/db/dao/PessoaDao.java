package br.fai.gb.db.dao;

import java.util.List;

import br.fai.gb.model.Pessoa;

public interface PessoaDao {

	List<Pessoa> readAll();

	Pessoa readById(Long id);

	Long create(Pessoa entity);

	boolean update(Pessoa entity);

	boolean delete(Long id);

}
