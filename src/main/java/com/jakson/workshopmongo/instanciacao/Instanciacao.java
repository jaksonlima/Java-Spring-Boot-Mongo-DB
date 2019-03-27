package com.jakson.workshopmongo.instanciacao;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.jakson.workshopmongo.dominio.Post;
import com.jakson.workshopmongo.dominio.Produto;
import com.jakson.workshopmongo.dominio.User;
import com.jakson.workshopmongo.repositorio.PostRepositorio;
import com.jakson.workshopmongo.repositorio.ProdutoRepositorio;
import com.jakson.workshopmongo.repositorio.UserRepositorio;

@Configuration
public class Instanciacao implements CommandLineRunner {

	@Autowired
	private UserRepositorio userRepositorio;
	@Autowired
	private ProdutoRepositorio produtoRepositorio;
	@Autowired
	private PostRepositorio postRepositorio;

	@Override
	public void run(String... args) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/HH/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

		userRepositorio.deleteAll();
		produtoRepositorio.deleteAll();
		postRepositorio.deleteAll();

		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User jac = new User(null, "Jakson Lima", "Jakson@gmail.com");

		Produto jakson = new Produto(null, "jakson", 2000.0);
		Produto jakson1 = new Produto(null, "jakson1", 2001.0);
		Produto jakson2 = new Produto(null, "jakson2", 2002.0);

		Post post1 = new Post(null, sdf.parse("2019/03/12"), "Partiu Comprar", "Comprei tv 43!", maria);
		Post post2 = new Post(null, sdf.parse("2019/03/23"), "Bora Loja", "feliz hoje com meu not novo!", alex);
		Post post3 = new Post(null, sdf.parse("2019/03/22"), "melhor loja", "Otimo para comprar!", jac);

		userRepositorio.saveAll(Arrays.asList(maria, alex, jac));
		produtoRepositorio.saveAll(Arrays.asList(jakson, jakson1, jakson2));
		postRepositorio.saveAll(Arrays.asList(post1, post2, post3));

	}

}
