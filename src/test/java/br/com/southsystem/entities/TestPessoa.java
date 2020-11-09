package br.com.southsystem.entities;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import br.com.southsystem.entities.enums.TipoPessoa;

public class TestPessoa {
	
	@Test
	public void testaInstanciaPessoa() {
		Pessoa pessoa = new Pessoa("José", TipoPessoa.PF, "123456789");
		
		
		for (int i = 0; i <= 10; i++) {
			assertTrue(pessoa.getScore() < 10);
		}
	}
}
