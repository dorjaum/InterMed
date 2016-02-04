package br.com.exame;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.exame.controller.PessoaRestController;
import br.com.exame.dao.PessoaRepositoryDAO;
import br.com.exame.entity.Pessoa;
import br.com.exame.service.PessoaService;

@RunWith(MockitoJUnitRunner.class)
public class TestController {

	
	@Mock
	private PessoaRepositoryDAO pessoaRepositoryDAO;
	
	private PessoaService pessoaService;
	
	private PessoaRestController pessoaRestController;
	
	@Before
	public void setUp(){
		pessoaRestController = new PessoaRestController(pessoaService);
	}
	
	@Test
	@Ignore
	public void deveCriarPessoa(){
		//Ver como injetar um pessoaRestController
		final Pessoa pessoaSalvaBD = criaPessoa();
		Pessoa pessoa = pessoaRestController.cadastraPessoa("joao", "123.456.78-90");
		Mockito.verify(pessoaService, Mockito.times(1)).save(pessoa);
		assertEquals("Pessoa retornada deveria vir do servico", pessoaSalvaBD, pessoa);
		
	}

	private Pessoa criaPessoa() {
		final Pessoa pessoa = new Pessoa("joao", "123.456.78-90");
		when(pessoaService.save(Mockito.any(Pessoa.class))).thenReturn(pessoa);
		return pessoa;
	}
}
