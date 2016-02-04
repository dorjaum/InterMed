package br.com.exame.service;

import java.util.List;

import br.com.exame.Application;
import br.com.exame.dao.ExameRepositoryDAO;
import br.com.exame.entity.Clinica;
import br.com.exame.entity.Exame;
import br.com.exame.entity.Pessoa;

public class ExameServiceImpl implements ExameService {

	private static ExameServiceImpl instance;
	
	private ExameRepositoryDAO exameRespositoryDAO;

	private ExameServiceImpl(){}
	
	private ExameServiceImpl(ExameRepositoryDAO exameRepositoryDAO){
		this.exameRespositoryDAO = exameRepositoryDAO;
	}
	
	public static ExameServiceImpl getInstance() {
		if(instance == null ){
			instance = new ExameServiceImpl(Application.getContext().getBean(ExameRepositoryDAO.class));
		}
		return instance;
	}

	public Exame save(Exame exame) {
		return exameRespositoryDAO.save(exame);
	}

	public List<Exame> findAllExame() {
		return (List<Exame>) exameRespositoryDAO.findAll();
	}

	public List<Exame> findAllByPessoa(Pessoa pessoa) {
		return exameRespositoryDAO.findAllByPessoa(pessoa);
	}

	public List<Exame> findAllByClinica(Clinica clinica) {
		return exameRespositoryDAO.findAllByClinica(clinica);
	}
	

}
