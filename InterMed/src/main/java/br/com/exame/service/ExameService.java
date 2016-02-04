package br.com.exame.service;

import java.util.List;

import br.com.exame.entity.Exame;
import br.com.exame.entity.Pessoa;

public interface ExameService {
	
	Exame save(Exame exame);
	
	List<Exame> findAllExame();
	
	List<Exame> findAllByPessoa(Pessoa pessoa);
}
