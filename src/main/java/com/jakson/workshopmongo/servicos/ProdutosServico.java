package com.jakson.workshopmongo.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jakson.workshopmongo.dominio.Produtos;
import com.jakson.workshopmongo.dto.CarinhoDTO;
import com.jakson.workshopmongo.repositorio.ProdutosRepositorio;
import com.jakson.workshopmongo.servicos.exception.ObjectNotFoundException;

@Service
public class ProdutosServico {

	@Autowired
	private ProdutosRepositorio produtoRepo;

	public List<Produtos> findAll() {
		return produtoRepo.findAll();
	}

	public Produtos findById(String id) {
		Optional<Produtos> obj = produtoRepo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public Produtos insert(Produtos obj) {
		return produtoRepo.insert(obj);
	}

	public Produtos fromDTO(CarinhoDTO obj) {
		return new Produtos(null, obj.getNome(), obj.getValor(), obj.getQuantidade());
	}

	public void delete(String id) {
		findById(id);
		produtoRepo.deleteById(id);
	}

	public Produtos update(Produtos obj) {
		Produtos newOBJ = findById(obj.getId());
		updateData(newOBJ, obj);
		return produtoRepo.save(newOBJ);

	}

	private void updateData(Produtos newOBJ, Produtos obj) {
		newOBJ.setNome(obj.getNome());
		newOBJ.setValor(obj.getValor());
	}
}
