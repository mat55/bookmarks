package br.com.locadorafilmes.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Table;
import javax.validation.constraints.NotBlank;



@Table(name = "categorias")
public class Categorias  {

	private long id;
	
	private String acao;
	
	private String ficcao;
	
	private String romance;
	
	private String drama;
	
	
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
	public String getAcao() {
		return acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}
	
	@NotBlank
	@Column
	public String getFiccao() {
		return ficcao;
	}

	public void setFiccao(String ficcao) {
		this.ficcao = ficcao;
	}
	
	@NotBlank
	@Column
	public String getRomance() {
		return romance;
	}

	public void setRomance(String romance) {
		this.romance = romance;
	}
	
	@NotBlank
	@Column
	public String getDrama() {
		return drama;
	}

	public void setDrama(String drama) {
		this.drama = drama;
	}

	
	
}
