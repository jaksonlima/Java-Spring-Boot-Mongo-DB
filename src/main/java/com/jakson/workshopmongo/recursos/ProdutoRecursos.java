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

import com.jakson.workshopmongo.dominio.Produto;
import com.jakson.workshopmongo.dto.ProdutoDTO;
import com.jakson.workshopmongo.servicos.ProdutoServico;

@RestController
@RequestMapping(value = "/produto")
public class ProdutoRecursos {

	@Autowired
	private ProdutoServico produtoRecu;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ProdutoDTO>> findAll() {
		List<Produto> list = produtoRecu.findAll();
		List<ProdutoDTO> listDTO = list.stream().map(x -> new ProdutoDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<ProdutoDTO> findById(@PathVariable String id) {
		Produto obj = produtoRecu.findById(id);
		return ResponseEntity.ok().body(new ProdutoDTO(obj));
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody ProdutoDTO objDTO) {
		Produto obj = produtoRecu.fromDTO(objDTO);
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
	public ResponseEntity<Void> update(@RequestBody ProdutoDTO objDTO, @PathVariable String id) {
		Produto obj = produtoRecu.fromDTO(objDTO);
		obj.setId(id);
		obj = produtoRecu.update(obj);
		return ResponseEntity.noContent().build();
	}

}
