package br.fai.gb.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.fai.gb.api.service.ContaService;
import br.fai.gb.db.dao.ContaDao;
import br.fai.gb.model.Conta;

@Service
public class ContaServiceImpl implements ContaService {

	@Autowired
	private ContaDao dao;

	@Override
	public List<Conta> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Conta readById(final Long id) {

		return dao.readById(id);
	}

	@Override
	public Long create(final Conta pessoa) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(final Conta pessoa) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(final Long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
