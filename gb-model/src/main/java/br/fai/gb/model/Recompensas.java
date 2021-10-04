package br.fai.gb.model;

public class Recompensas extends BasePojo {

	private double saldo;
	private Long contaId;

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(final double saldo) {
		this.saldo = saldo;
	}

	public Long getContaId() {
		return contaId;
	}

	public void setContaId(final Long contaId) {
		this.contaId = contaId;
	}

}
