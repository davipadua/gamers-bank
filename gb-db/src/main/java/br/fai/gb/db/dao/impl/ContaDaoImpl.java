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

//			String sql = "select * from pessoa ";
//			sql += " inner join conta on conta.pessoa_id = pessoa.id ";
//			sql += " where conta.id = ?;";

			String sql = "select * from conta ";
			sql += " inner join pessoa on pessoa.id = conta.pessoa_id ";
			sql += " where pessoa.id = ?;";

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, id);
//			preparedStatement.setLong(2, pessoa_id);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {

				conta = new Conta();
				conta.setId(resultSet.getLong("id"));
				conta.setNumero(resultSet.getInt("numero"));
				conta.setSaldoAtual(resultSet.getDouble("saldo_atual"));
				conta.setTaxaJuros(resultSet.getDouble("taxa_juros"));
				conta.setPessoaId(resultSet.getLong("pessoa_id"));

				conta.setNome(resultSet.getString("nome"));

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
		sql += " (nome, email, cpf, renda, senha) ";
		sql += " VALUES(?, ?, ?, ?, ?); ";

		Long id = Long.valueOf(-1);

		try {
			connection = ConnectionFactory.getConnection();
			connection.setAutoCommit(false);

			preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			preparedStatement.setString(1, entity.getNome());
			preparedStatement.setString(2, entity.getEmail());
			preparedStatement.setString(3, entity.getCpf());
			preparedStatement.setDouble(4, entity.getRenda());
			preparedStatement.setString(5, entity.getSenha());

			preparedStatement.execute();

			resultSet = preparedStatement.getGeneratedKeys();
			if (resultSet.next()) {
				id = resultSet.getLong(1);
			}

			sql = " INSERT INTO conta ";
			sql += " (numero, saldo_atual, pessoa_id, taxa_juros)";
			sql += " values(?, ?, ?, ?);";

			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, (int) (Math.random() * ((9999 - 1000) + 1)) + 1000);
			preparedStatement.setDouble(2, 1000);
			preparedStatement.setLong(3, id);
			preparedStatement.setLong(4, 0);

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
	public boolean update(final Conta entity) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String sql = "UPDATE pessoa SET nome = ?, ";
		sql += " senha = ?, ";
		sql += " renda = ? ";
		sql += " WHERE id = ?; ";

		try {
			connection = ConnectionFactory.getConnection();
			connection.setAutoCommit(false);

			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, entity.getNome());
			preparedStatement.setString(2, entity.getSenha());
			preparedStatement.setDouble(3, entity.getRenda());
			preparedStatement.setLong(4, entity.getId());

			preparedStatement.execute();

			connection.commit();

			return true;

		} catch (final Exception e) {

			try {
				connection.rollback();
			} catch (final SQLException e1) {
				System.out.println(e1.getMessage());
			}

			return false;

		} finally {
			ConnectionFactory.close(preparedStatement, connection);
		}

	}

	@Override
	public boolean delete(final Long id) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		final String sql = "DELETE FROM pessoa WHERE id = ?; ";

		try {
			connection = ConnectionFactory.getConnection();
			connection.setAutoCommit(false);

			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setLong(1, id);

			preparedStatement.execute();

			connection.commit();

			return true;

		} catch (final Exception e) {

			try {
				connection.rollback();
			} catch (final SQLException e1) {
				System.out.println(e1.getMessage());
			}

			return false;

		} finally {
			ConnectionFactory.close(preparedStatement, connection);
		}

	}

	@Override
	public boolean transfere(final Conta envia, final Conta recebe) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String sql = "UPDATE conta SET saldo_atual = saldo_atual - ? ";
		sql += " WHERE id = ?; ";

		try {
			connection = ConnectionFactory.getConnection();
			connection.setAutoCommit(false);

			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setDouble(1, envia.getSaldoAtual());
			preparedStatement.setLong(2, envia.getId());

			preparedStatement.execute();

			sql = "UPDATE conta SET saldo_atual = saldo_atual + ? ";
			sql += " WHERE numero = ?; ";

			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setDouble(1, recebe.getSaldoAtual());
			preparedStatement.setInt(2, envia.getNumero());

			preparedStatement.execute();

			connection.commit();

			return true;

		} catch (final Exception e) {

			try {
				connection.rollback();
			} catch (final SQLException e1) {
				System.out.println(e1.getMessage());
			}

			return false;

		} finally {
			ConnectionFactory.close(preparedStatement, connection);
		}
	}

	@Override
	public Conta login(final String email, final String senha) {

		Conta conta = null;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {

			connection = ConnectionFactory.getConnection();

			String sql = "select * from conta ";
			sql += " inner join pessoa on pessoa.id = conta.pessoa_id ";
			sql += " where pessoa.email = ? and pessoa.senha = ? ;";

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, senha);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {

				conta = new Conta();
				conta.setId(resultSet.getLong("id"));
				conta.setNumero(resultSet.getInt("numero"));
				conta.setSaldoAtual(resultSet.getDouble("saldo_atual"));
				conta.setTaxaJuros(resultSet.getDouble("taxa_juros"));
				conta.setPessoaId(resultSet.getLong("pessoa_id"));

				conta.setNome(resultSet.getString("nome"));

			}

		} catch (final Exception e) {
			System.out.println(e.getMessage());
		} finally {
			ConnectionFactory.close(resultSet, preparedStatement, connection);
		}

		return conta;
	}

}
