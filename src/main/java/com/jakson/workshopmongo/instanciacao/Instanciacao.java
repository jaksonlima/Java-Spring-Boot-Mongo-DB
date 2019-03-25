package com.jakson.workshopmongo.instanciacao;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.jakson.workshopmongo.dominio.User;
import com.jakson.workshopmongo.repositorio.UserRepositorio;

@Configuration
public class Instanciacao implements CommandLineRunner {

	@Autowired
	private UserRepositorio userRepositorio;

	@Override
	public void run(String... args) throws Exception {

		userRepositorio.deleteAll();

		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User jac = new User(null, "Jakson Lima", "Jakson@gmail.com");

		userRepositorio.saveAll(Arrays.asList(maria, alex, jac));
	}

}
