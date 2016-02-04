package br.com.exame.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.exame.entity.Clinica;

@Repository
public interface ClinicaRepositoryDAO extends CrudRepository<Clinica, Long>{

	/**
	 * Encontra uma clinica baseada no cnpj.
	 * @param cnpj
	 * @return Clinica
	 */
	Clinica findClinicaByCnpj(@Param("cnpj") String cnpj);
	
}
