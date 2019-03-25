package com.jakson.workshopmongo.servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jakson.workshopmongo.dominio.Produto;
import com.jakson.workshopmongo.repositorio.ProdutoRepositorio;
import com.jakson.workshopmongo.servicos.exception.ObjectNotFoundException;

@Service
public class ProdutoServico {

	@Autowired
	private ProdutoRepositorio produtoRepo;

	public List<Produto> findAll() {
		return produtoRepo.findAll();
	}

	public Produto findByID(String id) {
		Produto produto = produtoRepo.findOne(id);
		if (produto == null) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		return produto;
	}
}
