package br.com.locadorafilmes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.locadorafilmes.model.Filmes;
import br.com.locadorafilmes.repository.FilmesRepository;

@RestController
public class FilmesController extends CategoriasController {

	@Autowired
	private FilmesRepository filmesRepository;
	
	@GetMapping("/")
	public String lista(ModelMap modelMap) {
		modelMap.put("lista", filmesRepository.findAll());
		return "lista";
	}
	
	@PostMapping("/cadastro")
	public String cadastrar(Filmes filmes) {
		this.filmesRepository.save(filmes);
		return "redirect:/";
	}
	@PutMapping("/cadastro/{id}")
	public String edicao(@PathVariable(value="id") int id, ModelMap modelMap) {
		Filmes filmes = filmesRepository.findById(id);
		modelMap.put("edit", filmes);
		return "cadastro";
	}
	
	@PostMapping("/update")
	public String editar(@RequestParam("id") int id, ModelMap modelMap, Filmes filmes) {
		filmes = filmesRepository.findById(id);
		this.filmesRepository.save(filmes);
		return "redirect:/";
	}
	
	@DeleteMapping(value = "/{id}/delete")
	    public String delete(@PathVariable int id) {
		filmesRepository.deleteById(id);
	        return "redirect:/";
	}
}
