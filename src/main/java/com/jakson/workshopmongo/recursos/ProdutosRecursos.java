package com.jakson.workshopmongo.recursos;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jakson.workshopmongo.dominio.Produtos;
import com.jakson.workshopmongo.dto.CarinhoDTO;
import com.jakson.workshopmongo.servicos.ProdutosServico;

@RestController
@RequestMapping(value = "/produtoss")
public class ProdutosRecursos {

	@Autowired
	private ProdutosServico produtoRecu;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Produtos>> findAll() {
		List<Produtos> list = produtoRecu.findAll();
		return ResponseEntity.ok().body(list);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Produtos> findById(@PathVariable String id) {
		Produtos obj = produtoRecu.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody CarinhoDTO objDTO) {
		Produtos obj = produtoRecu.fromDTO(objDTO);
		obj = produtoRecu.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable String id) {
		produtoRecu.delete(id);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody CarinhoDTO objDTO, @PathVariable String id) {
		Produtos obj = produtoRecu.fromDTO(objDTO);
		obj.setId(id);
		obj = produtoRecu.update(obj);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{id}/produtos", method = RequestMethod.GET)
	public ResponseEntity<String> findProdutos(@PathVariable String id) {
		Produtos obj = produtoRecu.findById(id);
		return ResponseEntity.ok().body(obj.getNome());
	}
}