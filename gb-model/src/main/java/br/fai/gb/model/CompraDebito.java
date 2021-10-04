package br.fai.gb.model;

import java.sql.Timestamp;

public class CompraDebito extends BasePojo {

	private Timestamp dataHora;
	private double valor;

	public Timestamp getDataHora() {
		return dataHora;
	}

	public void setDataHora(final Timestamp dataHora) {
		this.dataHora = dataHora;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(final double valor) {
		this.valor = valor;
	}

}
