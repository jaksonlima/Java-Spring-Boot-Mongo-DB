package com.jakson.workshopmongo.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jakson.workshopmongo.dominio.User;
import com.jakson.workshopmongo.dto.UserDTO;
import com.jakson.workshopmongo.repositorio.UserRepositorio;
import com.jakson.workshopmongo.servicos.exception.ObjectNotFoundException;

@Service
public class UserServico {

	@Autowired
	private UserRepositorio userRepo;

	public List<User> findAll() {
		return userRepo.findAll();
	}

	public User findById(String id) {
		Optional<User> obj = userRepo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public User insert(User obj) {
		return userRepo.insert(obj);
	}

	public User fromDTO(UserDTO obj) {
		return new User(obj.getId(), obj.getNome(), obj.getEmail());
	}

	public void delete(String id) {
		findById(id);
		userRepo.deleteById(id);
	}

	public User update(User obj) {
		User newOBJ = findById(obj.getId());
		updateData(newOBJ, obj);
		return userRepo.save(newOBJ);

	}

	private void updateData(User newOBJ, User obj) {
		newOBJ.setNome(obj.getNome());
		newOBJ.setEmail(obj.getEmail());
	}
}