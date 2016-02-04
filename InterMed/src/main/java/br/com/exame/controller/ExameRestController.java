package br.com.exame.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.exame.entity.Clinica;
import br.com.exame.entity.Exame;
import br.com.exame.entity.Pessoa;
import br.com.exame.exception.ClinicaExcetpion;
import br.com.exame.exception.PessoaException;
import br.com.exame.service.ClinicaServiceImpl;
import br.com.exame.service.ExameServiceImpl;
import br.com.exame.service.PessoaServiceImpl;

@RestController
@RequestMapping("/exame")
public class ExameRestController {

	
	private static final String CPF_INEXISTENTE_OU_PESSOA_NAO_CADASTRADA = "CPF Inexistente ou pessoa não cadastrada";
	private static final String CLINICA_NAO_CADASTRADA_OU_CNPJ_INEXISTENTE = "Clinica não cadastrada ou Cnpj inexistente";

	
	/**
	 * Cadastra um exame para uma pessoa que esteja relacionada a uma clinica. 
	 * Tanto a pessoa quanto a clinica devem estar previamente cadastradas na base para que o cadastro do 
	 * exame se conclua.
	 * 
	 * @param String cpfPessoa
	 * @param String cnpjClinica
	 * @param String resultado
	 * @param String urlImagem
	 * @return Exame
	 */
	@RequestMapping("/cadastra")
	public Exame cadastra(
			@RequestParam(value="cpfPessoa") String cpfPessoa,
			@RequestParam(value="cnpjClinica") String cnpjClinica,
			@RequestParam(value="resultado", defaultValue="") String resultado,
			@RequestParam(value="urlImagem", defaultValue="") String urlImagem
			){
		
		Pessoa pessoa = getPessoaPorCpf(cpfPessoa);
		Clinica clinica = getClinicaPorCnpj(cnpjClinica);

		return saveExame(resultado, urlImagem, pessoa, clinica);
	}


	/**
	 * Traz todos os exames relacionadas a uma pessoa.
	 * @param String cpf
	 * @return List<Exame>
	 */
	@RequestMapping("/todosPorPessoa")
	public List<Exame> todosPorPessoa(@RequestParam(value="idPessoa") String cpf){
		Pessoa pessoa = PessoaServiceImpl.getInstance().findPessoaByCpf(cpf);
		return ExameServiceImpl.getInstance().findAllByPessoa(pessoa);
	}
	
	/**
	 * Traz todos os exames pela clinica, passando-se o cnpj da mesma.
	 * @param cnpj
	 * @return List<Exame>
	 */
	@RequestMapping("/todosPorClinica")
	public List<Exame> todosPorClinica(@RequestParam(value="cnpj") String cnpj){
		Clinica clinica = ClinicaServiceImpl.getInstance().findClinicaByCnpj(cnpj);
		return ExameServiceImpl.getInstance().findAllByClinica(clinica);
	}
	
	/**
	 * Traz todos os exames cadastrados na base.
	 * @return List<Exame>
	 */
	@RequestMapping("/todos")
	public List<Exame> todos(){
		return ExameServiceImpl.getInstance().findAllExame();
	}

	private Exame saveExame(String resultado, String urlImagem, Pessoa pessoa, Clinica clinica) {
		Exame exame = new Exame(pessoa, clinica, resultado, urlImagem);
		return ExameServiceImpl.getInstance().save(exame);
	}
	
	private Clinica getClinicaPorCnpj(String cnpjClinica) {
		Clinica clinica = ClinicaServiceImpl.getInstance().findClinicaByCnpj(cnpjClinica);
		if(clinica == null){
			throw new ClinicaExcetpion(CLINICA_NAO_CADASTRADA_OU_CNPJ_INEXISTENTE);
		}
		
		return clinica;
	}

	private Pessoa getPessoaPorCpf(String cpfPessoa) {
		Pessoa pessoa = PessoaServiceImpl.getInstance().findPessoaByCpf(cpfPessoa);
		if(pessoa == null){
			throw new PessoaException(CPF_INEXISTENTE_OU_PESSOA_NAO_CADASTRADA);
		}
		
		return pessoa;
	}

}
