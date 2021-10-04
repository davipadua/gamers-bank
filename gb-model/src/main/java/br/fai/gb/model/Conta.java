package br.fai.gb.model;

public class Conta extends BasePojo {

	private int numero;
	private double saltoAtual;
	private double taxaJuros;
	private Long pessoaId;

	public int getNumero() {
		return numero;
	}

	public void setNumero(final int numero) {
		this.numero = numero;
	}

	public double getSaltoAtual() {
		return saltoAtual;
	}

	public void setSaltoAtual(final double saltoAtual) {
		this.saltoAtual = saltoAtual;
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
