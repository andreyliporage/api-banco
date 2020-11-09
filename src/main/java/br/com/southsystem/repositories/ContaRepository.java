package br.com.southsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.southsystem.entities.Conta;

public interface ContaRepository extends JpaRepository<Conta, String>{

}
