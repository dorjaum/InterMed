package br.com.exame.service;

import java.util.List;

import br.com.exame.entity.Pessoa;


public interface PessoaService {

	/**
	 * Salva uma entidade Pessoa na base.
	 * @param pessoa
	 * @return Pessoa.
	 */
	public Pessoa save(Pessoa pessoa);
	
	/**
	 * Retorn todas as pessoas cadastradas na base.
	 * @return List<Pessoa>
	 */
	public List<Pessoa> findAll();
	
	/**
	 * Retorna uma entidade Pessoa baseada no Id do cadastro.
	 * @param id
	 * @return Pessoa
	 */
	public Pessoa findPessoaById(Long id);

	/**
	 * Retorna uma entidade Pessoa cadastrada com o cpf passado como parâmetro.
	 * @param cpf
	 * @return Pessoa
	 */
	public Pessoa findPessoaByCpf(String cpf);
	
	
}
