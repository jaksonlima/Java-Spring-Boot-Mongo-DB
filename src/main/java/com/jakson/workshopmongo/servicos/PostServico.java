package com.jakson.workshopmongo.servicos;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jakson.workshopmongo.dominio.Post;
import com.jakson.workshopmongo.repositorio.PostRepositorio;
import com.jakson.workshopmongo.servicos.exception.ObjectNotFoundException;

@Service
public class PostServico {

	@Autowired
	private PostRepositorio postRepo;

	public Post findById(String id) {
		Optional<Post> obj = postRepo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public List<Post> findByTitle(String texto) {
		return postRepo.searchTitle(texto);
	}

	public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
		return postRepo.fullSearch(text, minDate, maxDate);
	}
}
