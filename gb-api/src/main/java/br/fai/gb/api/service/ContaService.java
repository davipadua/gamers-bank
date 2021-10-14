package br.fai.gb.api.service;

import java.util.List;

import br.fai.gb.model.Conta;

public interface ContaService {

	List<Conta> readAll();

	Conta readById(Long id);

	Long create(Conta conta);

	boolean update(Conta conta);

	boolean delete(Long id);

}
