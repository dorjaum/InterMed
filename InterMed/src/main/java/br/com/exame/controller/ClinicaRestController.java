package br.com.exame.controller;

import java.util.List;

import org.h2.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.exame.entity.Clinica;
import br.com.exame.exception.ClinicaExcetpion;
import br.com.exame.service.ClinicaServiceImpl;
import br.com.exame.utils.ValidadorUtils;

@RestController
@RequestMapping("/clinica")
public class ClinicaRestController {

	private static final String CNPJ_FORNECIDO_INVALIDO = "Cnpj fornecido inválido";
	private static final String CLINICA_COM_CNPJ_JA_CADASTRADO = "Clinica com cnpj ja cadastrado";
	private static final String DADOS_INCOMPLETOS = "Dados da clinica incompletos, os dados passados devem ser \"razaoSocial\" e \"cnpj\"";

	/**
	 * Cadastra uma clinica levando-se em conta apenas a razao social e o cnpj.
	 * @param razaoSocial
	 * @param cnpj
	 * @return Clinica
	 */
	@RequestMapping("/cadastra")
	public Clinica cadastra(
			@RequestParam(value="razaoSocial") String razaoSocial,
			@RequestParam(value="cnpj") String cnpj){
		
		validaDadosRazaoSocial(razaoSocial);
		validaDadosCnpj(cnpj);
		validaCnpjExistente(cnpj);
		
		return ClinicaServiceImpl.getInstance().save(new Clinica(razaoSocial, cnpj));
	}
	
	/**
	 * Retorna todas as clinicas cadastradas na base.
	 * @return List<Clinica>
	 */
	@RequestMapping("/todos")
	public List<Clinica> todos(){
		return ClinicaServiceImpl.getInstance().findAllClinica();
	}
	
	/**
	 * Retorna clinica associada ao cnpj.
	 * @param cnpj
	 * @return Clinica
	 */
	@RequestMapping("/findClinicaByCnpj")
	public Clinica findClinicaByCnpj(@RequestParam(value="cnpj") String cnpj){
		return ClinicaServiceImpl.getInstance().findClinicaByCnpj(cnpj);
	}
	
	private void validaCnpjExistente(String cnpj) {
		 Clinica clinicaByCnpj = ClinicaServiceImpl.getInstance().findClinicaByCnpj(cnpj);
		if(clinicaByCnpj != null){
			throw new ClinicaExcetpion(CLINICA_COM_CNPJ_JA_CADASTRADO);
		}
	}

	private void validaDadosRazaoSocial(String dados) {
		if(StringUtils.isNullOrEmpty(dados)){
			throw new ClinicaExcetpion(DADOS_INCOMPLETOS);
		}
	}
	
	private void validaDadosCnpj(String cnpj) {
		if(StringUtils.isNullOrEmpty(cnpj)){
			throw new ClinicaExcetpion(DADOS_INCOMPLETOS);
		}
		
		if(!ValidadorUtils.isCnpjValido(cnpj)){
			throw new ClinicaExcetpion(CNPJ_FORNECIDO_INVALIDO);
		}
	}

}
