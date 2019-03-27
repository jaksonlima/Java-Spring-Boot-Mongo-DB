package com.jakson.workshopmongo.dominio;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Repository;

import com.jakson.workshopmongo.dto.AutorDTO;

@Repository
public class Post implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private Date data;
	private String título;
	private String corpo;
	private AutorDTO autorDTO;

	public Post() {
	}

	public Post(String id, Date data, String título, String corpo, AutorDTO autorDTO) {
		this.id = id;
		this.data = data;
		this.título = título;
		this.corpo = corpo;
		this.setAutorDTO(autorDTO);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getTítulo() {
		return título;
	}

	public void setTítulo(String título) {
		this.título = título;
	}

	public String getCorpo() {
		return corpo;
	}

	public void setCorpo(String corpo) {
		this.corpo = corpo;
	}

	public AutorDTO getAutorDTO() {
		return autorDTO;
	}

	public void setAutorDTO(AutorDTO autorDTO) {
		this.autorDTO = autorDTO;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", data=" + data + ", título=" + título + ", corpo=" + corpo + ", autorDTO="
				+ autorDTO + "]";
	}

}
