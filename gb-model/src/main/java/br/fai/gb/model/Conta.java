package br.fai.gb.model;

public class Conta extends BasePojo {

	private int numero;
	private double saldoAtual;
	private double taxaJuros;
	private Long pessoaId;

	public int getNumero() {
		return numero;
	}

	public void setNumero(final int numero) {
		this.numero = numero;
	}

	public double getSaldoAtual() {
		return saldoAtual;
	}

	public void setSaldoAtual(final double saldoAtual) {
		this.saldoAtual = saldoAtual;
	}

	public double getTaxaJuros() {
		return taxaJuros;
	}

	public void setTaxaJuros(final double taxaJuros) {
		this.taxaJuros = taxaJuros;
	}

	public Long getPessoaId() {
		return pessoaId;
	}

	public void setPessoaId(final Long pessoaId) {
		this.pessoaId = pessoaId;
	}

}
