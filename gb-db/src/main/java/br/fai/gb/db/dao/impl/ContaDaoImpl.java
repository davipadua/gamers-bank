package br.fai.gb.db.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
		// TODO Auto-generated method stub
		return null;
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
