package br.edu.fapce.sc.CrudPessoa.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fapce.sc.CrudPessoa.modelo.Pessoa;
import br.edu.fapce.sc.CrudPessoa.repository.PessoaRepository;
import java.util.List;
import java.util.Optional;

@RestController
public class PessoaController {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@RequestMapping(value = "/pessoa", method = PUT)
	public Optional<Pessoa> update(@RequestBody Pessoa pessoa2) {
		return pessoaRepository.findById(pessoa2.getId()).map(pessoa -> {
			pessoa.setIdade(pessoa2.getIdade());
			pessoa.setNome(pessoa2.getNome());
			return pessoaRepository.save(pessoa);
		});
	}
	
	@RequestMapping(value = "/pessoa/{id}", method = DELETE)
	public void delete(@PathVariable int id) {
		pessoaRepository.deleteById(id);
	}
	
	@RequestMapping(value = "/pessoa/{id}", method = GET)
	public Optional<Pessoa> getPessoaPorId(@PathVariable int id) {
		return pessoaRepository.findById(id);
	}
	
	@RequestMapping(value = "/pessoa", method = GET)
	public List<Pessoa> getPessoas() {
		return pessoaRepository.findAll();
	}
	
	@RequestMapping(value = "/pessoa", method = POST)
	public Pessoa criar(@RequestBody Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}
}
