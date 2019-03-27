package com.jakson.workshopmongo.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.jakson.workshopmongo.dominio.Produto;

@Repository
public interface ProdutoRepositorio extends MongoRepository<Produto, String> {

}
