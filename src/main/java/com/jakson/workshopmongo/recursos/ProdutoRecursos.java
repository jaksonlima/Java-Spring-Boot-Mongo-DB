package com.jakson.workshopmongo.recursos;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jakson.workshopmongo.dominio.Produto;
import com.jakson.workshopmongo.dto.ProdutoDTO;
import com.jakson.workshopmongo.servicos.ProdutoServico;

@RestController
@RequestMapping(value = "/produtos")
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
		Produto produto = produtoRecu.findByID(id);
		return ResponseEntity.ok().body(new ProdutoDTO(produto));
	}

}
