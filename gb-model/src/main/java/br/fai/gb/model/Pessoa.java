package br.fai.gb.model;

public class Pessoa extends BasePojo {

	private String nome;
	private String email;
	private String cpf;
	private double renda;

	public String getNome() {
		return nome;
	}

	public void setNome(final String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(final String cpf) {
		this.cpf = cpf;
	}

	public double getRenda() {
		return renda;
	}

	public void setRenda(final double renda) {
		this.renda = renda;
	}

}
