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

import br.com.locadorafilmes.model.Categorias;
import br.com.locadorafilmes.repository.CategoriasRepository;

@RestController
public class CategoriasController {

	@Autowired
	private CategoriasRepository categoriasRepository;
	
	@GetMapping("/")
	public String lista(ModelMap modelMap) {
		modelMap.put("lista", categoriasRepository.findAll());
		return "lista";
	}
	
	@PostMapping("/cadastro")
	public String cadastrar(Categorias categorias) {
		this.categoriasRepository.save(categorias);
		return "redirect:/";
	}
	@PutMapping("/cadastro/{id}")
	public String edicao(@PathVariable(value="id") int id, ModelMap modelMap) {
		Categorias categorias = categoriasRepository.findById(id);
		modelMap.put("edit", categorias);
		return "cadastro";
	}
	
	@PostMapping("/update")
	public String editar(@RequestParam("id") int id, ModelMap modelMap, Categorias categorias) {
		categorias = categoriasRepository.findById(id);
		this.categoriasRepository.save(categorias);
		return "redirect:/";
	}
	
	@DeleteMapping(value = "/{id}/delete")
	    public String delete(@PathVariable int id) {
		categoriasRepository.deleteById(id);
	        return "redirect:/";
	}

}
