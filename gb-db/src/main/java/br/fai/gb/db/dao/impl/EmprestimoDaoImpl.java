package br.fai.gb.db.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import br.fai.gb.db.connection.ConnectionFactory;
import br.fai.gb.db.dao.EmprestimoDao;
import br.fai.gb.model.Emprestimo;

public class EmprestimoDaoImpl implements EmprestimoDao {

	@Override
	public List<Emprestimo> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Emprestimo readById(final Long id) {

		Emprestimo emprestimo = null;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {

			connection = ConnectionFactory.getConnection();

			String sql = "select * from emprestimo ";
			sql += " inner join conta on conta.id = emprestimo.conta_id ";
			sql += " where conta.id = ?;";

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, id);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {

				emprestimo = new Emprestimo();
				emprestimo.setId(resultSet.getLong("id"));
				emprestimo.setFinalidade(resultSet.getString("finalidade"));
				emprestimo.setDataHora(resultSet.getTimestamp("datahora"));
				emprestimo.setContaId(resultSet.getInt("conta_id"));
				emprestimo.setMontante(resultSet.getLong("id"));

			}

		} catch (final Exception e) {

		}

		return emprestimo;
	}

	@Override
	public Long create(final Emprestimo entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(final Emprestimo entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(final Long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
