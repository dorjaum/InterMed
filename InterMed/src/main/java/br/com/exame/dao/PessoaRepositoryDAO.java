package br.com.exame.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.exame.entity.Pessoa;

@Repository
public interface PessoaRepositoryDAO extends CrudRepository<Pessoa, Long> {

	/**
	 * Retorna uma lista de pessoas baseada no nome
	 * @param nome
	 * @return List<Pessoa>
	 */
	List<Pessoa> findByNome(@Param("nome") String nome);

	/**
	 * Retorn uma unica Pessoa passando-se o cpf como parametro.
	 * @param cpf
	 * @return Pessoa
	 */
	Pessoa findByCpf(@Param("cpf") String cpf);
}
