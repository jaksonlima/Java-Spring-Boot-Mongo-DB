package com.jakson.workshopmongo.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.jakson.workshopmongo.dominio.Post;

@Repository
public interface PostRepositorio extends MongoRepository<Post, String> {

}
