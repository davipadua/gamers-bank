package br.fai.gb.model;

public class Extrato extends BasePojo {

	private String descricao;
	private double valor;
	private int contaId;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(final String descricao) {
		this.descricao = descricao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(final double valor) {
		this.valor = valor;
	}

	public int getContaId() {
		return contaId;
	}

	public void setContaId(final int contaId) {
		this.contaId = contaId;
	}

}
