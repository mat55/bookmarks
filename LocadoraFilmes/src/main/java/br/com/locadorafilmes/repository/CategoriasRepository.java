package br.com.locadorafilmes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.locadorafilmes.model.Categorias;


public interface CategoriasRepository extends JpaRepository<Categorias, String> {

	List<Categorias > findAll();
	
	Categorias save (Categorias categorias);
	
	Categorias findById(int id);
	
	Categorias deleteById (int id);
}
