package com.jakson.workshopmongo.recursos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jakson.workshopmongo.dominio.Produto;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoRecursos {

	@RequestMapping(method = RequestMethod.GET)
	public List<Produto> findAll() {
		Produto produt = new Produto("Placa de Video", "1", 2000);
		Produto produto = new Produto("Placa", "2", 5000);
		List<Produto> list = new ArrayList<>();
		list.addAll(Arrays.asList(produt, produto));
		return list;
	}

}
