package br.com.exame.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pessoa {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String nome;
	private String cpf;
	
	protected Pessoa(){
		
	}
	
	public Pessoa(String nome, String cpf){
		this.setNome(nome);
		this.setCpf(cpf);
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Long getId(){
		return id;
	}
	
	@Override
	public String toString() {
		return String.format("Pessoa[id=%d, nome='%s', cpf='%s']", id, nome,cpf);
	}
}
