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
	public Long create(final Conta conta) {

		return dao.create(conta);
	}

	@Override
	public boolean update(final Conta conta) {

		return dao.update(conta);
	}

	@Override
	public boolean delete(final Long id) {

		return dao.delete(id);
	}

	@Override
	public boolean transfere(final Conta envia, final Conta recebe) {

		return dao.transfere(envia, recebe);
	}

	@Override
	public Conta login(final String email, final String senha) {

		return dao.login(email, senha);
	}

}
