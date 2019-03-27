package com.jakson.workshopmongo.dto;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.jakson.workshopmongo.dominio.User;

@Document
public class AutorDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private String nome;

	public AutorDTO() {
	}

	public AutorDTO(User obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}