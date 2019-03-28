package com.jakson.workshopmongo.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.jakson.workshopmongo.dominio.Produtos;

@Repository
public interface ProdutosRepositorio extends MongoRepository<Produtos, String> {

}
