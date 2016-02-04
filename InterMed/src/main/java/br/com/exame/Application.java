package br.com.exame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import br.com.exame.dao.PessoaRepositoryDAO;
import br.com.exame.entity.Pessoa;

@SpringBootApplication
@ComponentScan(basePackages={"br.com.exame"})
public class Application {

	private static ConfigurableApplicationContext context;
	
	public static void main(String[] args) {
		context = SpringApplication.run(Application.class, args);
	}
	
	public static ConfigurableApplicationContext getContext(){
		return context;
	}
		
		
}
