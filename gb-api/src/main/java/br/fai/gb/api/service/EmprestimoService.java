package br.fai.gb.api.service;

import java.util.List;

import br.fai.gb.model.Emprestimo;

public interface EmprestimoService {

	List<Emprestimo> readAll();

	Emprestimo readById(Long id);

	Long create(Emprestimo emprestimo);

	boolean update(Emprestimo emprestimo);

	boolean delete(Long id);

}
