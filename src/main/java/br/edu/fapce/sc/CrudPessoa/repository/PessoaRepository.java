package br.edu.fapce.sc.CrudPessoa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.fapce.sc.CrudPessoa.modelo.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

}
