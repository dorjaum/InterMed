package br.com.exame.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.exame.entity.Pessoa;

@Repository
public interface PessoaRepositoryDAO extends CrudRepository<Pessoa, Long> {

	List<Pessoa> findByNome(@Param("nome") String nome);

	Pessoa findByCpf(@Param("cpf") String cpf);
}
