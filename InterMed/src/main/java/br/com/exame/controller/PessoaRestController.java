package br.com.exame.controller;



import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.h2.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.exame.dao.PessoaRepositoryDAO;
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
	PessoaRepositoryDAO pessoaRepository;
	
	@RequestMapping( value="/cadastra")
	public Pessoa cadastraPessoa(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value="nome") String nome, 
			@RequestParam(value="cpf") String cpf ){
		
		validaDadosEntrada(nome);
		validaDadosEntrada(cpf);
		validaCpfExiste(cpf);
		
		return savePessoa(nome, cpf);
	}

	@RequestMapping(value="/todos", method=RequestMethod.GET)
	public List<Pessoa> todasPessoas(){
		return PessoaServiceImpl.getInstance().findAll();
	}
	
	private Pessoa savePessoa(String nome, String cpf) {
		PessoaService instance = PessoaServiceImpl.getInstance();
		return instance.save(new Pessoa(nome, cpf));
	}
	
	private void validaCpfExiste(String cpf) {
		Pessoa findPessoaByCpf = PessoaServiceImpl.getInstance().findPessoaByCpf(cpf);
		if(findPessoaByCpf != null){
			throw new PessoaException(PESSOA_JA_CADASTRADA_COM_ESSE_CPF);
		}
		
	}
	
	private void validaDadosEntrada(String dados) {
		if(StringUtils.isNullOrEmpty(dados)){
			throw new PessoaExcetpion(DADOS_INCOMPLETOS);
		}
	}
}
