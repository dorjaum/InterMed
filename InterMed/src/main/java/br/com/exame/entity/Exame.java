package br.com.exame.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Exame {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@OneToOne
	private Pessoa pessoa;
	@OneToOne

	private Clinica clinica;
	private String resultado;
	private String urlImagem;

	
	public Exame(){
	}
	
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public Long getId(){
		return id;
	}
	
	public Exame(Pessoa pessoa, String resultado) {
		this.pessoa = pessoa;
		this.resultado = resultado;
	}

	public Exame(Pessoa pessoa, Clinica clinica, String resultado, String urlImagem) {
		this.pessoa = pessoa;
		this.clinica = clinica;
		this.resultado = resultado;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public Clinica getClinica() {
		return clinica;
	}

	public void setClinica(Clinica clinica) {
		this.clinica = clinica;
	}
}
