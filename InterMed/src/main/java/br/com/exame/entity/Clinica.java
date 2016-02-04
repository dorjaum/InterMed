package br.com.exame.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Clinica {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String cnpj;
	private String razaoSocial;
	
	public Clinica(){}
	
	public Clinica(String razaoSocial, String cnpj){
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
	}

	public Long getId(){
		return id;
	}
	
	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

}
