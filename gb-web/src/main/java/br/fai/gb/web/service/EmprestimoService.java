package br.fai.gb.web.service;

import java.util.List;

import br.fai.gb.model.Emprestimo;

public interface EmprestimoService {

	List<Emprestimo> readAll();

	Long create(Emprestimo emprestimo);

	Emprestimo readById(Long id);

	boolean update(Emprestimo emprestimo);

	boolean deleteById(Long id);

}
