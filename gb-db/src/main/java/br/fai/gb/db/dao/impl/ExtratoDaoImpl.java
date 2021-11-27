package br.fai.gb.db.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.fai.gb.db.connection.ConnectionFactory;
import br.fai.gb.db.dao.ExtratoDao;
import br.fai.gb.model.Extrato;

@Repository
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
				extrato.setValor(resultSet.getDouble("valor"));
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

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		String sql = " INSERT INTO extrato ";
		sql += " (descricao, valor, conta_id) ";
		sql += " VALUES(?, ?, ?); ";

		Long id = Long.valueOf(-1);

		try {
			connection = ConnectionFactory.getConnection();
			connection.setAutoCommit(false);

			preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			preparedStatement.setString(1, entity.getDescricao());
			preparedStatement.setDouble(2, entity.getValor());
			preparedStatement.setDouble(3, id);

			preparedStatement.execute();

			resultSet = preparedStatement.getGeneratedKeys();
			if (resultSet.next()) {
				id = resultSet.getLong(1);
			}

			connection.commit();

		} catch (final Exception e) {

			try {
				connection.rollback();
			} catch (final SQLException e1) {
				System.out.println(e1.getMessage());
			}

		} finally {
			ConnectionFactory.close(resultSet, preparedStatement, connection);
		}

		return id;
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
