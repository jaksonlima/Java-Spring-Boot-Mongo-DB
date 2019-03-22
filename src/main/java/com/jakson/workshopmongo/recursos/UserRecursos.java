package com.jakson.workshopmongo.recursos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jakson.workshopmongo.dominio.User;

@RestController
@RequestMapping(value = "/userss")
public class UserRecursos {

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> findAll() {
		User jakson = new User("1", "jakson", "jakson@gmail.com");
		User bru = new User("2", "Bruna", "bru@gmail.com");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(jakson, bru));
		return ResponseEntity.ok().body(list);
	}

}
