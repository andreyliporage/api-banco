package br.com.southsystem.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.southsystem.entities.Conta;
import br.com.southsystem.services.ContaService;

@RestController
@RequestMapping("/contas")
public class ContaResource {

	@Autowired
	private ContaService service;
	
	@GetMapping
	public ResponseEntity<List<Conta>> findAll() {
		List<Conta> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
	}
}
