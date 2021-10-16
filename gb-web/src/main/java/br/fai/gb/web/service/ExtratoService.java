package br.fai.gb.web.service;

import java.util.List;

import br.fai.gb.model.Extrato;

public interface ExtratoService {

	List<Extrato> readAll(Long id);

	Long create(Extrato extrato);

	Extrato readById(Long id);

	boolean update(Extrato extrato);

	boolean deleteById(Long id);

}
