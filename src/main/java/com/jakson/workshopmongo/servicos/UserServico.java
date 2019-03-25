package com.jakson.workshopmongo.servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jakson.workshopmongo.dominio.User;
import com.jakson.workshopmongo.repositorio.UserRepositorio;
import com.jakson.workshopmongo.servicos.exception.ObjectNotFoundException;

@Service
public class UserServico {

	@Autowired
	private UserRepositorio userRepo;

	public List<User> findAll() {
		return userRepo.findAll();
	}

	public User findByID(String id) {
		User user = userRepo.findOne(id);
		if (user == null) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		} else {
			return user;
		}
	}
}
