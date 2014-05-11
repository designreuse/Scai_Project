/**
 * 
 */
package net.com.scaiprojectv.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

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

	@ManyToOne
	private Funcionario docente;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.EAGER)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<HorarioDiaAula> horariosAulas;

	private String nomeTurma;

	@Temporal(TemporalType.DATE)
	private Date previsaoInicio;

	private Double valorCurso;

	private Integer alunosMatriculados;

	@OneToOne(mappedBy = "turma",cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
	private Matricula matricula;

	public Matricula getMatricula() {
		return matricula;
	}

	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Double getPorcentagemDeVagasDisponiveis() {
		return (double) (alunosMatriculados * 100) / vagasDisponiveis;
	}

}
