/**
 * 
 */
package net.com.scaiprojectv.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Comment(s): 
 * 
 * @author Paulo Garcia
 * @Feb 26, 2014
 * @5:28:17 PM
 *
 * Scai Project_V®
 *
 * Developed by Paulo Garcia
 */
@Entity
public class Mensalidade {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Temporal(TemporalType.DATE)
	private Date dataVencimento;
	
	@Column(nullable = true)
	private Double valorPago;
	
	@ManyToOne
	private Funcionario funcionario;
	
	private String obersacao;
	
	@ManyToOne
	@JoinColumn(name = "id_pagamento")
	private Pagamento pagamento;

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Double getValorPago() {
		return valorPago;
	}

	public void setValorPago(Double valorPago) {
		this.valorPago = valorPago;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public String getObersacao() {
		return obersacao;
	}

	public void setObersacao(String obersacao) {
		this.obersacao = obersacao;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	public Long getId() {
		return id;
	}
	
	
	
}
