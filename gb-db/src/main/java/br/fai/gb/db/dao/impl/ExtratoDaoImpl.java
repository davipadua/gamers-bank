package br.fai.gb.db.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.fai.gb.db.connection.ConnectionFactory;
import br.fai.gb.db.dao.ExtratoDao;
import br.fai.gb.model.Extrato;

public class ExtratoDaoImpl implements ExtratoDao {

	@Override
	public List<Extrato> readAll(final Long id) {

		final List<Extrato> extratos = new ArrayList<Extrato>();

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {

			connection = ConnectionFactory.getConnection();

			String sql = "SELECT * FROM extrato";
			sql += "inner join conta on conta.id = extrato.conta_id";
			sql += "where conta.id = ?";

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, id);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				final Extrato extrato = new Extrato();

				extrato.setId(resultSet.getLong("id"));
				extrato.setDescricao(resultSet.getString("descricao"));
				extrato.setData(resultSet.getTimestamp("data"));
				extrato.setContaId(resultSet.getInt("conta_id"));

				extratos.add(extrato);
			}

		} catch (final Exception e) {
			// TODO: handle exception
		} finally {

			ConnectionFactory.close(resultSet, preparedStatement, connection);

		}

		return extratos;
	}

	@Override
	public Extrato readById(final Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long create(final Extrato entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(final Extrato entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(final Long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
