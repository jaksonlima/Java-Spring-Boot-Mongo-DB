package com.jakson.workshopmongo.instanciacao;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.jakson.workshopmongo.dominio.Produtos;
import com.jakson.workshopmongo.dominio.Usuarios;
import com.jakson.workshopmongo.repositorio.PostRepositorio;
import com.jakson.workshopmongo.repositorio.ProdutoRepositorio;
import com.jakson.workshopmongo.repositorio.ProdutosRepositorio;
import com.jakson.workshopmongo.repositorio.UserRepositorio;
import com.jakson.workshopmongo.repositorio.UsuariosRepositorio;

@Configuration
public class Instanciacao implements CommandLineRunner {

	@Autowired
	private UserRepositorio userRepositorio;
	@Autowired
	private ProdutoRepositorio produtoRepositorio;
	@Autowired
	private PostRepositorio postRepositorio;
	@Autowired
	private UsuariosRepositorio usuariosRepositorios;
	@Autowired
	private ProdutosRepositorio produtosRepositorio;

	@Override
	public void run(String... args) throws Exception {

//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/HH/dd");
//		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
//
		userRepositorio.deleteAll();
		produtoRepositorio.deleteAll();
		postRepositorio.deleteAll();
		usuariosRepositorios.deleteAll();
		produtosRepositorio.deleteAll();
//
//		User maria = new User(null, "Maria Brown", "maria@gmail.com");
//		User alex = new User(null, "Alex Green", "alex@gmail.com");
//		User jac = new User(null, "Jakson Lima", "Jakson@gmail.com");
//
//		userRepositorio.saveAll(Arrays.asList(maria, alex, jac));
//		
//		Produto jakson = new Produto(null, "Desktop", 2000.0);
//		Produto jakson1 = new Produto(null, "HD Externo", 2001.0);
//		Produto jakson2 = new Produto(null, "Mouse", 2002.0);
//
//		produtoRepositorio.saveAll(Arrays.asList(jakson, jakson1, jakson2));
//
//		Post post1 = new Post(null, sdf.parse("2019/03/12"), "Partiu Comprar", "Comprei tv 43!", new AutorDTO(maria));
//		Post post2 = new Post(null, sdf.parse("2019/03/23"), "Bora Loja", "feliz hoje not novo!", new AutorDTO(maria));
//		Post post3 = new Post(null, sdf.parse("2019/03/22"), "melhor loja", "Otimo para comprar!", new AutorDTO(jac));
//
//		CommentDTO c1 = new CommentDTO("Excelente produto", sdf.parse("2019/02/11"), new AutorDTO(alex));
//		CommentDTO c2 = new CommentDTO("Produto otimo", sdf.parse("2019/02/11"), new AutorDTO(jac));
//		CommentDTO c3 = new CommentDTO("Otima qualidade", sdf.parse("2019/02/11"), new AutorDTO(maria));

		Usuarios usuarios = new Usuarios(null, "Rudmar", "Rudmar@gmail.com");
		Usuarios usuarios1 = new Usuarios(null, "jakson", "jakson@gmail.com");
		Usuarios usuarios2 = new Usuarios(null, "Bruna", "Bruna@gmail.com");

		usuariosRepositorios.saveAll(Arrays.asList(usuarios, usuarios1, usuarios2));

		Produtos produtos = new Produtos(null, "Teclado", 250.0, 2.0);
		Produtos produtos1 = new Produtos(null, "Mouse RGB", 250.0, 2.0);
		Produtos produtos2 = new Produtos(null, "Monitos 144HZ", 250.0, 2.0);

		produtosRepositorio.saveAll(Arrays.asList(produtos, produtos1, produtos2));

//
//		post1.getComments().addAll(Arrays.asList(c1, c2));
//		post2.getComments().addAll(Arrays.asList(c3));
//
//		postRepositorio.saveAll(Arrays.asList(post1, post2, post3));
//
//		maria.getPosts().addAll(Arrays.asList(post1, post2));
//		userRepositorio.save(maria);
//		jac.getPosts().addAll(Arrays.asList(post3));
//		userRepositorio.save(jac);
//
//		jakson.getPosts().addAll(Arrays.asList(post1, post2));
//		produtoRepositorio.save(jakson);
//		jakson1.getPosts().addAll(Arrays.asList(post3));
//		produtoRepositorio.save(jakson1);

		usuarios.getProdutos().addAll(Arrays.asList(produtos, produtos1));
		usuariosRepositorios.save(usuarios);
		usuarios1.getProdutos().addAll(Arrays.asList(produtos1, produtos2));
		usuariosRepositorios.save(usuarios1);
		usuarios2.getProdutos().addAll(Arrays.asList(produtos, produtos2));
		usuariosRepositorios.save(usuarios2);
	}

}