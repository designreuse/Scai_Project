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
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Comment(s): 
 * 
 * @author Paulo Garcia
 * @Feb 21, 2014
 * @8:58:48 AM
 *
 * Scai Project_V®
 *
 * Developed by Paulo Garcia
 */
@Entity
@PrimaryKeyJoinColumn(name = "id_pessoa")
public class Aluno extends Pessoa{

	@Column(nullable = true)
	private Short diaVencimentoMensalidade;
	
	private String nomeResponsavel;
	
	private String rgResponsavel;
	
	@OneToOne
	@JoinColumn(name = "id_matricula")
	private Matricula matricula;

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

	public Matricula getMatricula() {
		return matricula;
	}

	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}
	
	
	
}
