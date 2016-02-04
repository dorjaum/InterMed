package br.com.exame.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.exame.entity.Clinica;
import br.com.exame.entity.Exame;
import br.com.exame.entity.Pessoa;

public interface ExameRepositoryDAO extends CrudRepository<Exame, Long> {

	/**
	 * Retorna uma lista de Exames por pessoa
	 * @param pessoa
	 * @return List<ExameL>
	 */
	List<Exame> findAllByPessoa(@Param("pessoa") Pessoa pessoa );
	
	/**
	 * Retorna uma lista de Exames por clinica
	 * @param clinica
	 * @return List<Exame>
	 */
	List<Exame> findAllByClinica(@Param("pessoa") Clinica clinica);
}
