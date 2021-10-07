package br.fai.gb.db.dao;

import java.util.List;

import br.fai.gb.model.Conta;

public interface ContaDao {

	List<Conta> readAll();

	Conta readById(Long id);

	Long create(Conta entity);

	boolean update(Conta entity);

	boolean delete(Long id);

}
