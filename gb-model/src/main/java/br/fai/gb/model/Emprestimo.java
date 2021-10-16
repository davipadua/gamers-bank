package br.fai.gb.model;

import java.sql.Timestamp;

public class Emprestimo extends BasePojo {

	private Timestamp dataHora;
	private String finalidade;
	private double montante;
	private int contaId;

	public Timestamp getDataHora() {
		return dataHora;
	}

	public void setDataHora(final Timestamp dataHora) {
		this.dataHora = dataHora;
	}

	public String getFinalidade() {
		return finalidade;
	}

	public void setFinalidade(final String finalidade) {
		this.finalidade = finalidade;
	}

	public double getMontante() {
		return montante;
	}

	public void setMontante(final double montante) {
		this.montante = montante;
	}

	public int getContaId() {
		return contaId;
	}

	public void setContaId(final int contaId) {
		this.contaId = contaId;
	}

}
