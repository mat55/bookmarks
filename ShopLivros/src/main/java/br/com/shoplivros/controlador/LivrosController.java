package br.com.shoplivros.controlador;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.shoplivros.modelo.Livros;
import br.com.shoplivros.repositorio.LivrosRepositorio;

@RestController
public class LivrosController {
	
	@Autowired
	private LivrosRepositorio lr;
	
	@GetMapping("/")
	public @ResponseBody Iterable<Livros> lista(ModelMap modelMap) {
		Iterable<Livros> lista = lr.findAll();
		return lista;
	}
	@GetMapping("/cadastro")
	public String cadastro() {
		return "cadastro";
	}
	@PostMapping("/cadastro")
	public Livros cadastrar(@RequestBody @Valid Livros livros) {
		livros = lr.save(livros);
		return livros;
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@RequestBody @PathVariable("id") long id) {
		lr.findById(id);
		return "redirect:/";
	}
	
	@PutMapping("/edit/{id}")
	public String editar(@RequestBody @RequestParam("id") long id, Livros livros) {
		lr.findById(id);
		lr.save(livros);
		return "redirect:/";
	}

	@DeleteMapping()
	public Livros delete(@RequestBody @RequestParam("id") long id, Livros livros) {
		lr.delete(livros);
		return livros;
	}
}
