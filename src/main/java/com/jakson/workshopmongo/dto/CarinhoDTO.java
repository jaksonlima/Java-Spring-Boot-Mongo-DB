package com.jakson.workshopmongo.dto;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.jakson.workshopmongo.dominio.Produtos;

@Document
public class CarinhoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private String nome;
	private Double valor;
	private Double quantidade;

	public CarinhoDTO() {
	}

	public CarinhoDTO(Produtos obj) {
		obj.setId(obj.getId());
		obj.setNome(obj.getNome());
		obj.setValor(obj.getValor());
		obj.setQuantidade(obj.getQuantidade());
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

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}

}
