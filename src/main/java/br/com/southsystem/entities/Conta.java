package br.com.southsystem.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import br.com.southsystem.entities.enums.TipoConta;

@Entity
public class Conta implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	private String numero;
	private String agencia;
	private Double limiteChequeEspecial;
	private Integer tipo;
	
	@OneToOne
	@JoinColumn(name = "documento_pessoa")
	private Pessoa pessoa;
	
	@OneToOne
	@JoinColumn(name = "id_cartaoCredito")
	private CartaoCredito cartaoCredito;
	
	public Conta() {
	}

	public Conta(String numero, String agencia, TipoConta tipo, Pessoa pessoa) {
		this.numero = numero;
		this.agencia = agencia;
		setTipo(tipo);
		this.pessoa = pessoa;
		this.limiteChequeEspecial = 0.0;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public Double getLimiteChequeEspecial() {
		return limiteChequeEspecial;
	}

	public void setLimiteChequeEspecial(Double limiteChequeEspecial) {
		this.limiteChequeEspecial = limiteChequeEspecial;
	}

	public TipoConta getTipo() {
		return TipoConta.valueOf(tipo);
	}

	public void setTipo(TipoConta tipo) {
		if (tipo != null) {
			this.tipo = tipo.getCode();
		}
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public CartaoCredito getCartaoCredito() {
		return cartaoCredito;
	}

	public void setCartaoCredito(CartaoCredito cartaoCredito) {
		this.cartaoCredito = cartaoCredito;
	}
}
