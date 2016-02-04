package br.com.exame.controller;



import java.util.List;

import javax.inject.Inject;

import org.h2.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.exame.entity.Pessoa;
import br.com.exame.exception.PessoaException;
import br.com.exame.exception.PessoaExcetpion;
import br.com.exame.service.PessoaService;
import br.com.exame.service.PessoaServiceImpl;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/pessoa")
public class PessoaRestController {

	private static final String DADOS_INCOMPLETOS = "Cadastro de pessoa com dados incompletos, dados devem conter \"nome\" e \"cpf\"";
	private static final String PESSOA_JA_CADASTRADA_COM_ESSE_CPF = "Pessoa ja cadastrada com esse cpf";

	PessoaService pessoaService;
	
	@Inject
	public PessoaRestController(PessoaService pessoaService) {
		this.pessoaService = pessoaService;
	}

	/**
	 * 
	 * @param nome, pessoa a ser cadastrada.
	 * @param cpf, identificacao unica de cada pessoa.
	 * @return
	 */
	@RequestMapping( value="/cadastra")
	public Pessoa cadastraPessoa(@RequestParam(value="nome") String nome, 
			@RequestParam(value="cpf") String cpf ){
		
		validaDadosEntrada(nome);
		validaDadosEntrada(cpf);
		validaCpfExiste(cpf);
		
		return savePessoa(nome, cpf);
	}

	/**
	 * Retorna todas as pessoas presentes na base
	 * @return Entidade Pessoa
	 */
	@RequestMapping(value="/todos", method=RequestMethod.GET)
	public List<Pessoa> todasPessoas(){
		return PessoaServiceImpl.getInstance().findAll();
	}
	
	/**
	 * Retorna a pessoa cadastrada na base para determinado cpf
	 * @param cpf
	 * @return Entidade Pessoa
	 */
	@RequestMapping(value="/findPessoaByCpf", method=RequestMethod.GET)
	public Pessoa findPessoaByCpf(@RequestParam(value="cpf") String cpf){
		return PessoaServiceImpl.getInstance().findPessoaByCpf(cpf);
	}
	
	private Pessoa savePessoa(String nome, String cpf) {
		PessoaService instance = PessoaServiceImpl.getInstance();
		return instance.save(new Pessoa(nome, cpf));
	}
	
	private void validaCpfExiste(String cpf) {
		Pessoa pessoa = PessoaServiceImpl.getInstance().findPessoaByCpf(cpf);
		
		if(pessoa != null){
			throw new PessoaException(PESSOA_JA_CADASTRADA_COM_ESSE_CPF);
		}
	}
	
	private void validaDadosEntrada(String dados) {
		if(StringUtils.isNullOrEmpty(dados)){
			throw new PessoaExcetpion(DADOS_INCOMPLETOS);
		}
	}
}
