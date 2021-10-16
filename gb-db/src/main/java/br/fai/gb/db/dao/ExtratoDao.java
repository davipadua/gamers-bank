package br.fai.gb.db.dao;

import java.util.List;

import br.fai.gb.model.Extrato;

public interface ExtratoDao {

	List<Extrato> readAll(final Long id);

	Extrato readById(Long id);

	Long create(Extrato entity);

	boolean update(Extrato entity);

	boolean delete(Long id);

}
