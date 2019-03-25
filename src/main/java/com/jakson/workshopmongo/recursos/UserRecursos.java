package com.jakson.workshopmongo.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jakson.workshopmongo.dominio.User;
import com.jakson.workshopmongo.servicos.UserServico;

@RestController
@RequestMapping(value = "/users")
public class UserRecursos {

	@Autowired
	private UserServico userserv;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> findAll() {
		List<User> list = userserv.findAll();
		return ResponseEntity.ok().body(list);
	}

}
