package br.fai.gb.api.service;

import java.util.List;

import br.fai.gb.model.Extrato;

public interface ExtratoService {

	List<Extrato> readAll(Long id);

	Extrato readById(Long id);

	Long create(Extrato extrato);

	boolean update(Extrato extrato);

	boolean delete(Long id);

}
