package br.fai.gb.model;

import java.sql.Timestamp;

public class Cartao extends BasePojo {

	private String numeroCartao;
	private String nome;
	private Timestamp dataValidade;
	private Long ContaId;

	public String getNumeroCartao() {
		return numeroCartao;
	}

	public void setNumeroCartao(final String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(final String nome) {
		this.nome = nome;
	}

	public Timestamp getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(final Timestamp dataValidade) {
		this.dataValidade = dataValidade;
	}

	public Long getContaId() {
		return ContaId;
	}

	public void setContaId(final Long contaId) {
		ContaId = contaId;
	}

}
