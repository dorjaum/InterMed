package br.com.exame.service;

import java.util.List;

import br.com.exame.entity.Clinica;

public interface ClinicaService {

	/**
	 * Salva a entidade Clinica na base.
	 * @param clinica
	 * @return Clinica
	 */
	Clinica save(Clinica clinica);
	
	/**
	 * Retorna todas as clinicas da base
	 * @return List<Clinica>
	 */
	List<Clinica> findAllClinica();
	
}
