/**
 * 
 */
package net.com.scaiprojectv.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Component;

/**
 * Comment(s):
 * 
 * @author Paulo Garcia
 * @Feb 21, 2014
 * @8:58:48 AM
 * 
 *          Scai Project_V®
 * 
 *          Developed by Paulo Garcia
 */
@Component
@Entity
@PrimaryKeyJoinColumn(name = "id_pessoa")
public class Aluno extends Pessoa {

	@Column(nullable = true)
	private Short diaVencimentoMensalidade;

	private String nomeResponsavel;

	private String rgResponsavel;

	@OneToMany(mappedBy = "aluno", cascade = { CascadeType.PERSIST,
			CascadeType.MERGE })
	private List<Matricula> matriculas = new ArrayList<Matricula>();

	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "id_pagamento")
	private Pagamento pagamento;

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	public Short getDiaVencimentoMensalidade() {
		return diaVencimentoMensalidade;
	}

	public void setDiaVencimentoMensalidade(Short diaVencimentoMensalidade) {
		this.diaVencimentoMensalidade = diaVencimentoMensalidade;
	}

	public String getNomeResponsavel() {
		return nomeResponsavel;
	}

	public void setNomeResponsavel(String nomeResponsavel) {
		this.nomeResponsavel = nomeResponsavel;
	}

	public String getRgResponsavel() {
		return rgResponsavel;
	}

	public void setRgResponsavel(String rgResponsavel) {
		this.rgResponsavel = rgResponsavel;
	}

	public List<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}

}
