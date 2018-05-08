package br.com.locadorafilmes.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "filmes")
public class Filmes  {

	private long id ;
	
	private String titulo ;
	
	private String diretor;
	
	private Date anolançamento;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	@NotBlank
	@Column
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	@NotBlank
	@Column
	public String getDiretor() {
		return diretor;
	}

	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}
	
	@Column
	public Date getAnolançamento() {
		return anolançamento;
	}

	public void setAnolançamento(Date anolançamento) {
		this.anolançamento = anolançamento;
	}
	
	
	

}
