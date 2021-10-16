package br.fai.gb.db.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.stereotype.Service;

import br.fai.gb.db.connection.ConnectionFactory;
import br.fai.gb.db.dao.ContaDao;
import br.fai.gb.model.Conta;

@Service
public class ContaDaoImpl implements ContaDao {

	@Override
	public List<Conta> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Conta readById(final Long id) {

		Conta conta = null;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {

			connection = ConnectionFactory.getConnection();

			String sql = "select * from pessoa ";
			sql += " inner join conta on conta.pessoa_id = pessoa.id ";
			sql += " where conta.id = ?;";

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, id);
//			preparedStatement.setLong(2, pessoa_id);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {

				conta = new Conta();
				conta.setId(resultSet.getLong("conta.id"));
				conta.setNumero(resultSet.getInt("conta.numero"));
				conta.setSaldoAtual(resultSet.getDouble("conta.saldo_atual"));
				conta.setTaxaJuros(resultSet.getDouble("conta.taxa_juros"));
				conta.setPessoaId(resultSet.getLong("conta.pessoa_id"));

				conta.setNome(resultSet.getString("pessoa.nome"));

			}

		} catch (final Exception e) {

		}

		return conta;
	}

	@Override
	public Long create(final Conta entity) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		String sql = " INSERT INTO pessoa ";
		sql += " (nome, email, cpf, renda) ";
		sql += " VALUES(?, ?, ?, ?); ";
		sql += " INSERT INTO conta ";
		sql += " (numero, saldo_atual, pessoa_id, taxa_juros)";
		sql += " values(?, ?, ?, ?);";

		Long id = Long.valueOf(-1);

		try {
			connection = ConnectionFactory.getConnection();
			connection.setAutoCommit(false);

			preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			preparedStatement.setString(1, entity.getNome());
			preparedStatement.setString(2, entity.getEmail());
			preparedStatement.setString(3, entity.getCpf());
			preparedStatement.setDouble(4, entity.getRenda());

			preparedStatement.setInt(5, (int) (Math.random() * ((9999 - 1000) + 1)) + 1000);
			preparedStatement.setDouble(6, 1000);
			preparedStatement.setLong(7, id);
			preparedStatement.setLong(8, 0);

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
	public boolean update(final Conta entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(final Long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
