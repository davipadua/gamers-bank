package br.fai.gb.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.fai.gb.api.service.EmprestimoService;
import br.fai.gb.db.dao.EmprestimoDao;
import br.fai.gb.model.Emprestimo;

@Service
public class EmprestimoServiceImpl implements EmprestimoService {

	@Autowired
	private EmprestimoDao dao;

	@Override
	public List<Emprestimo> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Emprestimo readById(final Long id) {

		return dao.readById(id);
	}

	@Override
	public Long create(final Emprestimo emprestimo) {

		// return dao.create(emprestimo);
		return null;
	}

	@Override
	public boolean update(final Emprestimo emprestimo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(final Long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
