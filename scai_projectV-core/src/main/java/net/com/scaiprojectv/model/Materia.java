/**
 * 
 */
package net.com.scaiprojectv.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import net.com.scaiprojectv.enumerator.TipoAlunoEnum;

/**
 * Comment(s):
 * 
 * @author Paulo Garcia
 * @Feb 26, 2014
 * @10:00:40 AM
 * 
 *           Scai Project_V®
 * 
 *           Developed by Paulo Garcia
 */
@Entity
public class Materia {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String nome;

	private Boolean status;

	@ManyToMany(mappedBy = "materia")
	private List<Funcionario> docentes = new ArrayList<Funcionario>();

	public Long getId() {
		return id;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getTpAluno() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Funcionario> getDocentes() {
		return docentes;
	}

	public void setDocentes(List<Funcionario> docentes) {
		this.docentes = docentes;
	}

}
