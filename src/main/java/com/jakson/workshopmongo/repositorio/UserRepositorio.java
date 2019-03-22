package com.jakson.workshopmongo.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.jakson.workshopmongo.dominio.User;

@Repository
public interface UserRepositorio extends MongoRepository<User, String> {

}
