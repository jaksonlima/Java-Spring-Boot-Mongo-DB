package com.jakson.workshopmongo.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.jakson.workshopmongo.dominio.Usuarios;

@Repository
public interface UsuariosRepositorio extends MongoRepository<Usuarios, String> {

}
