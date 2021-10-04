package br.fai.gb.model;

import java.sql.Timestamp;

public class Fatura extends BasePojo {

	private double saldo;
	private Timestamp dataVencimento;
	// private Long CartaoCreditoId;

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(final double saldo) {
		this.saldo = saldo;
	}

	public Timestamp getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(final Timestamp dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

//	public Long getCartaoCreditoId() {
//		return CartaoCreditoId;
//	}
//
//	public void setCartaoCreditoId(final Long cartaoCreditoId) {
//		CartaoCreditoId = cartaoCreditoId;
//	}

}
