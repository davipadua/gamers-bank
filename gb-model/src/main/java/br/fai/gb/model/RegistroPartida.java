package br.fai.gb.model;

import java.sql.Timestamp;

public class RegistroPartida extends BasePojo {

	private int ponto;
	private Timestamp dataHora;
	private Long RecompensasId;

	public int getPonto() {
		return ponto;
	}

	public void setPonto(final int ponto) {
		this.ponto = ponto;
	}

	public Timestamp getDataHora() {
		return dataHora;
	}

	public void setDataHora(final Timestamp dataHora) {
		this.dataHora = dataHora;
	}

	public Long getRecompensasId() {
		return RecompensasId;
	}

	public void setRecompensasId(final Long recompensasId) {
		RecompensasId = recompensasId;
	}

}
