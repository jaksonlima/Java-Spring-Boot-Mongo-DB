package com.jakson.workshopmongo.recursos;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jakson.workshopmongo.dominio.Produtos;
import com.jakson.workshopmongo.dominio.Usuarios;
import com.jakson.workshopmongo.dto.UsuariosDTO;
import com.jakson.workshopmongo.servicos.UsuariosServico;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuariosRecursos {

	@Autowired
	private UsuariosServico userserv;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UsuariosDTO>> findAll() {
		List<Usuarios> list = userserv.findAll();
		List<UsuariosDTO> listDTO = list.stream().map(x -> new UsuariosDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<UsuariosDTO> findById(@PathVariable String id) {
		Usuarios obj = userserv.findById(id);
		return ResponseEntity.ok().body(new UsuariosDTO(obj));
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody UsuariosDTO objDTO) {
		Usuarios obj = userserv.fromDTO(objDTO);
		obj = userserv.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable String id) {
		userserv.delete(id);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody UsuariosDTO objDTO, @PathVariable String id) {
		Usuarios obj = userserv.fromDTO(objDTO);
		obj.setId(id);
		obj = userserv.update(obj);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{id}/posts", method = RequestMethod.GET)
	public ResponseEntity<List<Produtos>> findPosts(@PathVariable String id) {
		Usuarios obj = userserv.findById(id);
		return ResponseEntity.ok().body(obj.getProdutos());
	}
}