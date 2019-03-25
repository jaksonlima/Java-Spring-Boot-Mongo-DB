package com.jakson.workshopmongo.instanciacao;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.jakson.workshopmongo.dominio.Produto;
import com.jakson.workshopmongo.dominio.User;
import com.jakson.workshopmongo.repositorio.ProdutoRepositorio;
import com.jakson.workshopmongo.repositorio.UserRepositorio;

@Configuration
public class Instanciacao implements CommandLineRunner {

	@Autowired
	private UserRepositorio userRepositorio;
	@Autowired
	private ProdutoRepositorio produtoRepositorio;

	@Override
	public void run(String... args) throws Exception {

		userRepositorio.deleteAll();
		produtoRepositorio.deleteAll();

		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User jac = new User(null, "Jakson Lima", "Jakson@gmail.com");

		Produto jakson = new Produto(null, "jakson", 2000.0);
		Produto jakson1 = new Produto(null, "jakson1", 2001.0);
		Produto jakson2 = new Produto(null, "jakson2", 2002.0);

		userRepositorio.saveAll(Arrays.asList(maria, alex, jac));
		produtoRepositorio.saveAll(Arrays.asList(jakson, jakson1, jakson2));
	}

}
