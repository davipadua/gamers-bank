package br.fai.gb.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.fai.gb.api.service.ExtratoService;
import br.fai.gb.db.dao.ExtratoDao;
import br.fai.gb.model.Extrato;

@Service
public class ExtratoServiceImpl implements ExtratoService {

	@Autowired
	private ExtratoDao dao;

	@Override
	public List<Extrato> readAll(final Long id) {

		return dao.readAll(id);
	}

	@Override
	public Extrato readById(final Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long create(final Extrato extrato) {

		return dao.create(extrato);
	}

	@Override
	public boolean update(final Extrato extrato) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(final Long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
