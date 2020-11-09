package br.com.southsystem.util;

import br.com.southsystem.entities.CartaoCredito;
import br.com.southsystem.entities.Conta;
import br.com.southsystem.entities.Pessoa;
import br.com.southsystem.entities.enums.TipoConta;
import br.com.southsystem.entities.enums.TipoPessoa;

public class Util {
	
	public static void validaScore(Conta conta, Pessoa pessoa, CartaoCredito cartao) {
		try {
			if (pessoa.getScore() == 0 || pessoa.getScore() == 1) {
				conta.setLimiteChequeEspecial(0.0);
				cartao.setLimite(0.0);
			} else if (pessoa.getScore() >= 2 && pessoa.getScore() <= 5) {
				conta.setLimiteChequeEspecial(1000.00);
				cartao.setLimite(200.00);
			} else if (pessoa.getScore() >= 6 && pessoa.getScore() <= 8) {
				conta.setLimiteChequeEspecial(2000.00);
				cartao.setLimite(2000.00);
			} else if (pessoa.getScore() == 9) {
				conta.setLimiteChequeEspecial(5000.00);
				cartao.setLimite(15000.00);
			} else {
				throw new Exception("Erro ao validar o score");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void validaTipoConta(Conta conta, Pessoa pessoa) {
		try {
			if (pessoa.getTipo().equals(TipoPessoa.PF)) {
				conta.setTipo(TipoConta.C);
			} else if (pessoa.getTipo().equals(TipoPessoa.PJ)){
				conta.setTipo(TipoConta.E);
			} else {
				throw new Exception("Tipo de conta inválido");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
