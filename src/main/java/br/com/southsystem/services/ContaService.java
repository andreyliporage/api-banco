package br.com.southsystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.southsystem.entities.Conta;
import br.com.southsystem.repositories.ContaRepository;

@Service
public class ContaService {
	
	@Autowired
	private ContaRepository repository;
	
	public List<Conta> findAll() {
		return repository.findAll();
	}
}
