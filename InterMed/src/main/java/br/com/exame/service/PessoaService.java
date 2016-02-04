package br.com.exame.service;

import java.util.List;

import br.com.exame.entity.Pessoa;


public interface PessoaService {

	public Pessoa save(Pessoa pessao);
	
	public List<Pessoa> findAll();
	
	public Pessoa findPessoaById(Long id);

	public Pessoa findPessoaByCpf(String cpf);
	
	
}
