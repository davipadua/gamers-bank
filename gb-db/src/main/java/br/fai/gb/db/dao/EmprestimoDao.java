package br.fai.gb.db.dao;

import java.util.List;

import br.fai.gb.model.Emprestimo;

public interface EmprestimoDao {

	List<Emprestimo> readAll();

	Emprestimo readById(Long id);

	Long create(Emprestimo entity);

	boolean update(Emprestimo entity);

	boolean delete(Long id);

}
