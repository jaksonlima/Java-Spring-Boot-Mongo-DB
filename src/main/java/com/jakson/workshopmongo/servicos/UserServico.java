package com.jakson.workshopmongo.servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jakson.workshopmongo.dominio.User;
import com.jakson.workshopmongo.repositorio.UserRepositorio;

@Service
public class UserServico {

	
	@Autowired
	private UserRepositorio userRepo;

	public List<User> findAll() {
		return userRepo.findAll();
	}

}
