package br.com.southsystem.entities;

import java.io.Serializable;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import br.com.southsystem.entities.enums.TipoPessoa;

@Entity
public class Pessoa implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String nome;
	private Integer tipo;
	
	@Id
	@Column(name = "documento")
	private String documento;
	private Integer score;
	
	public Pessoa() {
	}
	
	public Pessoa(String nome, TipoPessoa tipo, String documento) {
		super();
		this.nome = nome;
		setTipo(tipo);
		this.documento = documento;
		setScore();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TipoPessoa getTipo() {
		return TipoPessoa.valueOf(tipo);
	}

	public void setTipo(TipoPessoa tipo) {
		if (tipo != null) {
			this.tipo = tipo.getCode();
		}
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore() {
		this.score = new Random().nextInt(10);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((documento == null) ? 0 : documento.hashCode());
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
		Pessoa other = (Pessoa) obj;
		if (documento == null) {
			if (other.documento != null)
				return false;
		} else if (!documento.equals(other.documento))
			return false;
		return true;
	}
}
