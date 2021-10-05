package bf.fai.gb.db.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import bf.fai.gb.db.connection.ConnectionFactory;
import bf.fai.gb.db.dao.PessoaDao;
import br.fai.gb.model.Pessoa;

@Repository
public class PessoaImpl implements PessoaDao {

	@Override
	public List<Pessoa> readAll() {

		final List<Pessoa> pessoas = new ArrayList<Pessoa>();

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {

			connection = ConnectionFactory.getConnection();

			final String sql = "SELECT * FROM pessoa;";

			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				final Pessoa pessoa = new Pessoa();
				pessoa.setId(resultSet.getLong("id"));
				pessoa.setNome(resultSet.getString("nome"));
				pessoa.setEmail(resultSet.getString("email"));
				pessoa.setCpf(resultSet.getString("cpf"));
				pessoa.setRenda(resultSet.getDouble("renda"));

				pessoas.add(pessoa);
			}

		} catch (final Exception e) {
			// TODO: handle exception
		} finally {

			ConnectionFactory.close(resultSet, preparedStatement, connection);

		}

		return pessoas;
	}

	@Override
	public Pessoa readById(final Long id) {

		Pessoa pessoa = null;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {

			connection = ConnectionFactory.getConnection();

			final String sql = "SELECT * FROM pessoa WHERE id = ?;";

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, id);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {

				pessoa = new Pessoa();
				pessoa.setId(resultSet.getLong("id"));
				pessoa.setNome(resultSet.getString("nome"));
				pessoa.setEmail(resultSet.getString("email"));
				pessoa.setCpf(resultSet.getString("cpf"));
				pessoa.setRenda(resultSet.getDouble("renda"));

			}

		} catch (final Exception e) {

		}

		return pessoa;
	}

	@Override
	public Long create(final Pessoa pessoa) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		String sql = "INSERT INTO pessoa";
		sql += " (nome, email, cpf, renda ";
		sql += " VALUES(?, ?, ?, ?); ";

		Long id = Long.valueOf(-1);

		try {
			connection = ConnectionFactory.getConnection();
			connection.setAutoCommit(false);

			preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			preparedStatement.setString(1, pessoa.getNome());
			preparedStatement.setString(2, pessoa.getEmail());
			preparedStatement.setString(3, pessoa.getCpf());
			preparedStatement.setDouble(4, pessoa.getRenda());

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
	public boolean update(final Pessoa pessoa) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String sql = "UPDATE pessoa SET nome = ?, ";
		sql += " email = ?, ";
		sql += " WHERE id = ?; ";

		try {
			connection = ConnectionFactory.getConnection();
			connection.setAutoCommit(false);

			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, pessoa.getNome());
			preparedStatement.setString(2, pessoa.getEmail());
			preparedStatement.setLong(3, pessoa.getId());

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

}
