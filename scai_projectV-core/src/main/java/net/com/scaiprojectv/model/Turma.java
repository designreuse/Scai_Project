/**
 * 
 */
package net.com.scaiprojectv.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.com.scaiprojectv.model.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * Comment(s): Classe de modelo da entidade Turma.
 * 
 * @author Paulo Garcia
 * @Feb 26, 2014
 * @11:03:42 AM
 * 
 *           Scai Project_V®
 * 
 *           Developed by Paulo Garcia
 */
@Entity
@JsonAutoDetect
public class Turma {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private Integer vagasDisponiveis;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_materia")
	private Materia materia;

	@Temporal(TemporalType.DATE)
	private Date previsaoTermino;

	@ManyToOne(cascade = { CascadeType.PERSIST })
	@JoinColumn(name = "id_docente")
	private Funcionario docente;

	@ManyToMany(mappedBy = "turmas", fetch = FetchType.EAGER)
	private List<Matricula> matriculas = new ArrayList<Matricula>();

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.EAGER)
	private List<HorarioDiaAula> horariosAulas;

	private String nomeTurma;

	@Temporal(TemporalType.DATE)
	private Date previsaoInicio;

	private Double valorCurso;

	private Integer alunosMatriculados;

	public List<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}

	public Integer getAlunosMatriculados() {
		return alunosMatriculados;
	}

	public void setAlunosMatriculados(Integer alunosMatriculados) {
		this.alunosMatriculados = alunosMatriculados;
	}

	public Long getId() {
		return id;
	}

	public List<HorarioDiaAula> getHorariosAulas() {
		return horariosAulas;
	}

	public void setHorariosAulas(List<HorarioDiaAula> horariosAulas) {
		this.horariosAulas = horariosAulas;
	}

	public Date getPrevisaoInicio() {
		return previsaoInicio;
	}

	public void setPrevisaoInicio(Date previsaoInicio) {
		this.previsaoInicio = previsaoInicio;
	}

	public Integer getVagasDisponiveis() {
		return vagasDisponiveis;
	}

	public void setVagasDisponiveis(Integer vagasDisponiveis) {
		this.vagasDisponiveis = vagasDisponiveis;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public Date getPrevisaoTermino() {
		return previsaoTermino;
	}

	public void setPrevisaoTermino(Date previsaoTermino) {
		this.previsaoTermino = previsaoTermino;
	}

	public Funcionario getDocente() {
		return docente;
	}

	public void setDocente(Funcionario docente) {
		this.docente = docente;
	}

	public String getNomeTurma() {
		return nomeTurma;
	}

	public void setNomeTurma(String nomeTurma) {
		this.nomeTurma = nomeTurma;
	}

	public Double getValorCurso() {
		return valorCurso;
	}

	public void setValorCurso(Double valorCurso) {
		this.valorCurso = valorCurso;
	}

}
