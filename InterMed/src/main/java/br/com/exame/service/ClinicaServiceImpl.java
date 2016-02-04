package br.com.exame.service;

import java.util.List;

import org.springframework.context.ApplicationContext;

import br.com.exame.Application;
import br.com.exame.dao.ClinicaRepositoryDAO;
import br.com.exame.entity.Clinica;

public class ClinicaServiceImpl implements ClinicaService {

	private static ClinicaServiceImpl instance;

	private ClinicaRepositoryDAO clinicaRepositoryDAO;
	
	private ClinicaServiceImpl(){}
	
	private ClinicaServiceImpl(ClinicaRepositoryDAO clinicaRepositoryDAO){
		this.clinicaRepositoryDAO = clinicaRepositoryDAO;
	}
	
	public static ClinicaServiceImpl getInstance(){
		if(instance == null){
			instance = new ClinicaServiceImpl(Application.getContext().getBean(ClinicaRepositoryDAO.class));
		}
			
		return instance;
	}
	public Clinica save(Clinica clinica) {
		return clinicaRepositoryDAO.save(clinica);
	}

	public List<Clinica> findAllClinica() {
		return (List<Clinica>) clinicaRepositoryDAO.findAll();
	}

	public Clinica findClinicaByCnpj(String cnpj) {
		return clinicaRepositoryDAO.findClinicaByCnpj(cnpj);
	}

}
