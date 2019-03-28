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
import com.jakson.workshopmongo.dto.AutorDTO;
import com.jakson.workshopmongo.dto.CommentDTO;
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

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/HH/dd");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

		userRepositorio.deleteAll();
		produtoRepositorio.deleteAll();
		postRepositorio.deleteAll();

		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User jac = new User(null, "Jakson Lima", "Jakson@gmail.com");

		userRepositorio.saveAll(Arrays.asList(maria, alex, jac));

		Produto jakson = new Produto(null, "Desktop", 2000.0);
		Produto jakson1 = new Produto(null, "HD Externo", 2001.0);
		Produto jakson2 = new Produto(null, "Mouse", 2002.0);

		produtoRepositorio.saveAll(Arrays.asList(jakson, jakson1, jakson2));

		Post post1 = new Post(null, sdf.parse("2019/03/12"), "Partiu Comprar", "Comprei tv 43!", new AutorDTO(maria));
		Post post2 = new Post(null, sdf.parse("2019/03/23"), "Bora Loja", "feliz hoje not novo!", new AutorDTO(maria));
		Post post3 = new Post(null, sdf.parse("2019/03/22"), "melhor loja", "Otimo para comprar!", new AutorDTO(jac));

		CommentDTO c1 = new CommentDTO("Excelente produto", sdf.parse("2019/02/11"), new AutorDTO(alex));
		CommentDTO c2 = new CommentDTO("Produto otimo", sdf.parse("2019/02/11"), new AutorDTO(jac));
		CommentDTO c3 = new CommentDTO("Otima qualidade", sdf.parse("2019/02/11"), new AutorDTO(maria));

		post1.getComments().addAll(Arrays.asList(c1, c2));
		post2.getComments().addAll(Arrays.asList(c3));

		postRepositorio.saveAll(Arrays.asList(post1, post2, post3));

		maria.getPosts().addAll(Arrays.asList(post1, post2));
		userRepositorio.save(maria);
		jac.getPosts().addAll(Arrays.asList(post3));
		userRepositorio.save(jac);

		jakson.getPosts().addAll(Arrays.asList(post1, post2));
		produtoRepositorio.save(jakson);
		jakson1.getPosts().addAll(Arrays.asList(post3));
		produtoRepositorio.save(jakson1);
	}

}