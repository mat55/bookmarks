package br.com.locadorafilmes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.locadorafilmes.model.Filmes;

public interface FilmesRepository extends JpaRepository<Filmes, String> {

	List<Filmes > findAll();
	
	Filmes save (Filmes filmes);
	
	Filmes findById(int id);
	
	Filmes deleteById (int id);
}