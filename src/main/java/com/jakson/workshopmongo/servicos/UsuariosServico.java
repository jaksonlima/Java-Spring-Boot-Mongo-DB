package com.jakson.workshopmongo.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jakson.workshopmongo.dominio.Usuarios;
import com.jakson.workshopmongo.dto.UsuariosDTO;
import com.jakson.workshopmongo.repositorio.UsuariosRepositorio;
import com.jakson.workshopmongo.servicos.exception.ObjectNotFoundException;

@Service
public class UsuariosServico {

	@Autowired
	private UsuariosRepositorio userRepo;

	public List<Usuarios> findAll() {
		return userRepo.findAll();
	}

	public Usuarios findById(String id) {
		Optional<Usuarios> obj = userRepo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public Usuarios insert(Usuarios obj) {
		return userRepo.insert(obj);
	}

	public Usuarios fromDTO(UsuariosDTO obj) {
		return new Usuarios(obj.getId(), obj.getNome(), obj.getEmail());
	}

	public void delete(String id) {
		findById(id);
		userRepo.deleteById(id);
	}

	public Usuarios update(Usuarios obj) {
		Usuarios newOBJ = findById(obj.getId());
		updateData(newOBJ, obj);
		return userRepo.save(newOBJ);

	}

	private void updateData(Usuarios newOBJ, Usuarios obj) {
		newOBJ.setNome(obj.getNome());
		newOBJ.setEmail(obj.getEmail());
	}
}