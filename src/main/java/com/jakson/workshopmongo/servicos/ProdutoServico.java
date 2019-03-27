package com.jakson.workshopmongo.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jakson.workshopmongo.dominio.Produto;
import com.jakson.workshopmongo.dto.ProdutoDTO;
import com.jakson.workshopmongo.repositorio.ProdutoRepositorio;
import com.jakson.workshopmongo.servicos.exception.ObjectNotFoundException;

@Service
public class ProdutoServico {

	@Autowired
	private ProdutoRepositorio produtoRepo;

	public List<Produto> findAll() {
		return produtoRepo.findAll();
	}

	public Produto findById(String id) {
		Optional<Produto> obj = produtoRepo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public Produto insert(Produto obj) {
		return produtoRepo.insert(obj);
	}

	public Produto fromDTO(ProdutoDTO obj) {
		return new Produto(obj.getId(), obj.getNome(), obj.getPreco());
	}

	public void delete(String id) {
		findById(id);
		produtoRepo.deleteById(id);
	}

	public Produto update(Produto obj) {
		Produto newOBJ = findById(obj.getId());
		updateData(newOBJ, obj);
		return produtoRepo.save(newOBJ);

	}

	private void updateData(Produto newOBJ, Produto obj) {
		newOBJ.setNome(obj.getNome());
		newOBJ.setPreco(obj.getPreco());
	}
}
