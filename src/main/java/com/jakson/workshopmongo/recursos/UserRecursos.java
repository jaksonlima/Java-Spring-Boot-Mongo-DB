package com.jakson.workshopmongo.recursos;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jakson.workshopmongo.dominio.User;
import com.jakson.workshopmongo.dto.UserDTO;
import com.jakson.workshopmongo.servicos.UserServico;

@RestController
@RequestMapping(value = "/users")
public class UserRecursos {

	@Autowired
	private UserServico userserv;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> findAll() {
		List<User> list = userserv.findAll();
		List<UserDTO> listDTO = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<UserDTO> findById(@PathVariable String id) {
		User user = userserv.findByID(id);
		return ResponseEntity.ok().body(new UserDTO(user));
	}

}
