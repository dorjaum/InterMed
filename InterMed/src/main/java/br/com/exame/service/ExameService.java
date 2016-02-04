package br.com.exame.service;

import java.util.List;

import br.com.exame.entity.Exame;
import br.com.exame.entity.Pessoa;

public interface ExameService {
	
	/**
	 * Salva uma entidade Exame na base;
	 * @param exame
	 * @return Exame
	 */
	Exame save(Exame exame);

	/**
	 * Retorna todos as entidades Exame presentes na base.
	 * @return List<Exame>
	 */
	List<Exame> findAllExame();
	
	/**
	 * Retorn todas entidades Exame relacionadas a uma pessoa.
	 * @param pessoa
	 * @return List<Exame>
	 */
	List<Exame> findAllByPessoa(Pessoa pessoa);
}
