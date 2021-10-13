package br.fai.gb.web.service;

import java.util.List;

import br.fai.gb.model.Conta;

public interface ContaService {

	List<Conta> readAll();

	Long create(Conta conta);

	Conta readById(Long id);

	boolean update(Conta conta);

	boolean deleteById(Long id);

}
