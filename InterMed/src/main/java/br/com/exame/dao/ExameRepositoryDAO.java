package br.com.exame.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.exame.entity.Exame;
import br.com.exame.entity.Pessoa;

public interface ExameRepositoryDAO extends CrudRepository<Exame, Long> {

	List<Exame> findAllByPessoa(@Param("pessoa") Pessoa pessoa );
}
