package com.jakson.workshopmongo.recursos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jakson.workshopmongo.dominio.Post;
import com.jakson.workshopmongo.servicos.PostServico;

@RestController
@RequestMapping(value = "/posts")
public class PostRecurso {

	@Autowired
	private PostServico servPost;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Post> findById(@PathVariable String id) {
		Post obj = servPost.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
