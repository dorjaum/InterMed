package br.com.exame.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.exame.Application;
import br.com.exame.dao.PessoaRepositoryDAO;
import br.com.exame.entity.Pessoa;

@Service
public class PessoaServiceImpl implements PessoaService {

	private PessoaRepositoryDAO pessoaRepository;
	
	private static PessoaService pessoaService;
	
	private PessoaServiceImpl(){}
	
	private PessoaServiceImpl(PessoaRepositoryDAO pessoaRepositoryDAO){
		this.pessoaRepository = pessoaRepositoryDAO;
	};
	
	public static PessoaService getInstance(){
		if(pessoaService == null){
			pessoaService = new PessoaServiceImpl(Application.getContext().getBean(PessoaRepositoryDAO.class));
		}
		
		return pessoaService;
	}
	
	@Transactional
	public Pessoa save(final Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}
	
	@Transactional
	public List<Pessoa> findAll(){
		return (List<Pessoa>) pessoaRepository.findAll();
	}

	public Pessoa findPessoaById(Long idPessoa) {
		return pessoaRepository.findOne(idPessoa);
	}

	public Pessoa findPessoaByCpf(String cpf) {
		return pessoaRepository.findByCpf(cpf);
	}

}
