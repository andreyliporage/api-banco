package br.com.southsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.southsystem.entities.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, String>{

}
