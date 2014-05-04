/**
 * 
 */
package net.com.scaiprojectv.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 * Comment(s):
 * 
 * @author Paulo Garcia
 * @Feb 21, 2014
 * @10:59:42 AM
 * 
 *           Scai Project_V®
 * 
 *           Developed by Paulo Garcia
 */
@Entity
public class Matricula {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = true)
	private Integer numeroMatricula;

	@Column(nullable = true)
	private Date dataMatricula;

	@ManyToOne
	@JoinColumn(name = "matricula")
	private Funcionario funcionario;
	
	/**
	 *A entity Pessoa está sendo marcada como dona do relacionamento pela anota-
	 *ção JoinTable, e aponta o nome da tabela de relacionamento. 
	 */
	@ManyToMany(fetch = FetchType.LAZY)
	private List<Turma> turmas = new ArrayList<Turma>();

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Long getId() {
		return id;
	}

	public Integer getNumeroMatricula() {
		return numeroMatricula;
	}

	public void setNumeroMatricula(Integer numeroMatricula) {
		this.numeroMatricula = numeroMatricula;
	}

	public Date getDataMatricula() {
		return dataMatricula;
	}

	public void setDataMatricula(Date dataMatricula) {
		this.dataMatricula = dataMatricula;
	}

}
