package br.fai.gb.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.fai.gb.api.service.PessoaService;
import br.fai.gb.db.dao.PessoaDao;
import br.fai.gb.model.Pessoa;

@Service
public class PessoaServiceImpl implements PessoaService {

	@Autowired
	private PessoaDao dao;

	@Override
	public List<Pessoa> readAll() {

		return dao.readAll();
	}

	@Override
	public Pessoa readById(final Long id) {

		return dao.readById(id);
	}

	@Override
	public Long create(final Pessoa pessoa) {

		return dao.create(pessoa);
	}

	@Override
	public boolean update(final Pessoa pessoa) {

		if (pessoa == null)
			return false;

		return dao.update(pessoa);
	}

	@Override
	public boolean delete(final Long id) {

		return dao.delete(id);
	}

}
