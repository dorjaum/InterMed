package br.com.exame.service;

import java.util.List;

import br.com.exame.entity.Clinica;

public interface ClinicaService {

	Clinica save(Clinica clinica);
	
	List<Clinica> findAllClinica();
	
}
