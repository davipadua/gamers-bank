package br.fai.gb.model;

import java.sql.Timestamp;

public class ContaTransfere extends BasePojo {

	private Long ContaId;
	private Long ContaTransfereId;
	private double valor;
	private Timestamp dataHora;

	public Long getContaId() {
		return ContaId;
	}

	public void setContaId(final Long contaId) {
		ContaId = contaId;
	}

	public Long getContaTransfereId() {
		return ContaTransfereId;
	}

	public void setContaTransfereId(final Long contaTransfereId) {
		ContaTransfereId = contaTransfereId;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(final double valor) {
		this.valor = valor;
	}

	public Timestamp getDataHora() {
		return dataHora;
	}

	public void setDataHora(final Timestamp dataHora) {
		this.dataHora = dataHora;
	}

}
