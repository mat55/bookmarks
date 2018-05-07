package br.com.shoplivros.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.shoplivros.modelo.Livros;

@Repository
public interface LivrosRepositorio extends CrudRepository<Livros, Long>{

}
