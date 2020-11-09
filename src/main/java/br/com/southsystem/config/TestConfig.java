package br.com.southsystem.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.southsystem.entities.CartaoCredito;
import br.com.southsystem.entities.Conta;
import br.com.southsystem.entities.Pessoa;
import br.com.southsystem.entities.enums.TipoConta;
import br.com.southsystem.entities.enums.TipoPessoa;
import br.com.southsystem.repositories.CartaoCreditoRepository;
import br.com.southsystem.repositories.ContaRepository;
import br.com.southsystem.repositories.PessoaRepository;
import br.com.southsystem.util.Util;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private ContaRepository contaRepository;
	
	@Autowired
	private CartaoCreditoRepository cartaoRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Pessoa p1 = new Pessoa("José Almeida", TipoPessoa.PF, "24454789154");
		Pessoa p2= new Pessoa("Márcia Amada", TipoPessoa.PJ, "24454789154123");
		Pessoa p3 = new Pessoa("Marcos Verde", TipoPessoa.PF, "24454759654");
		Pessoa p4 = new Pessoa("Gepeto Mogno", TipoPessoa.PF, "62344789154");
		
		Conta conta1 = new Conta("456159", "1002", TipoConta.C, p1);
		Conta conta2 = new Conta("256159", "1004", TipoConta.E, p2);
		Conta conta3 = new Conta("956159", "1001", TipoConta.C, p3);
		Conta conta4 = new Conta("756159", "1003", TipoConta.C, p4);

		CartaoCredito cartao1 = new CartaoCredito(10L, 100.00);
		CartaoCredito cartao2 = new CartaoCredito(115L, 200.00);
		CartaoCredito cartao3 = new CartaoCredito(184L, 500.00);
		CartaoCredito cartao4 = new CartaoCredito(187L, 1000.00);
		
		Util.validaScore(conta1, p1, cartao1);
		Util.validaScore(conta2, p2, cartao2);
		Util.validaScore(conta3, p3, cartao3);
		Util.validaScore(conta4, p4, cartao4);
		
		Util.validaTipoConta(conta1, p1);
		Util.validaTipoConta(conta2, p2);
		Util.validaTipoConta(conta3, p3);
		Util.validaTipoConta(conta4, p4);
		
		pessoaRepository.saveAll(Arrays.asList(p1, p2, p3, p4));
		contaRepository.saveAll(Arrays.asList(conta1, conta2, conta3, conta4));
		cartaoRepository.saveAll(Arrays.asList(cartao1, cartao2, cartao3, cartao4));
		
	}
	
	
}
