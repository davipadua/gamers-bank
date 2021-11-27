package br.fai.gb.db.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.stereotype.Service;

import br.fai.gb.db.connection.ConnectionFactory;
import br.fai.gb.db.dao.EmprestimoDao;
import br.fai.gb.model.Emprestimo;

@Service
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
				emprestimo.setMontante(resultSet.getLong("montante"));

			}

		} catch (final Exception e) {

		}

		return emprestimo;
	}

	@Override
	public Long create(final Emprestimo entity, final Long contaId) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		String sql = " INSERT INTO emprestimo ";
		sql += " (datahora, finalidade, montante, conta_id)";
		sql += " values(?, ?, ?, ?);";

		Long id = Long.valueOf(-1);

		try {
			connection = ConnectionFactory.getConnection();
			connection.setAutoCommit(false);

			preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			preparedStatement.setTimestamp(1, entity.getDataHora());
			preparedStatement.setString(2, entity.getFinalidade());
			preparedStatement.setDouble(3, entity.getMontante());
			preparedStatement.setLong(4, contaId);

			preparedStatement.execute();

			resultSet = preparedStatement.getGeneratedKeys();
			if (resultSet.next()) {
				id = resultSet.getLong(1);
			}

			sql = " update conta ";
			sql += " set saldo_atual = saldo_atual + ?";
			sql += " where conta.id = ? ";

			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setDouble(1, entity.getMontante());
			preparedStatement.setLong(2, contaId);

			preparedStatement.execute();

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
