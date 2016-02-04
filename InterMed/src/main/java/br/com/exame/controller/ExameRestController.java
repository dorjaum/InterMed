package br.com.exame.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;
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


	@RequestMapping("/cadastra")
	public Exame cadastraPorCpf(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value="cpfPessoa") String cpfPessoa,
			@RequestParam(value="cnpjClinica") String cnpjClinica,
			@RequestParam(value="resultado", defaultValue="") String resultado,
			@RequestParam(value="urlImagem", defaultValue="") String urlImagem
			){
		
		Pessoa pessoa = getPessoaPorCpf(cpfPessoa);
		Clinica clinica = getClinicaPorCnpj(cnpjClinica);

		return saveExame(resultado, urlImagem, pessoa, clinica);
	}


	@RequestMapping("/todosPorPessoa")
	public List<Exame> todosPorPessoa(@RequestParam(value="idPessoa") Long idPessoa){
		Pessoa pessoa = PessoaServiceImpl.getInstance().findPessoaById(idPessoa);
		return ExameServiceImpl.getInstance().findAllByPessoa(pessoa);
	}
	
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
