/**
 * 
 */
package net.com.scaiprojectv.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.Length;

/**
 * Comment(s): Classe modelo de cidade.
 * 
 * @author Paulo Garcia
 * @Feb 21, 2014
 * @8:31:34 AM
 *
 * Scai Project_V®
 *
 * Developed by Paulo Garcia
 */
@Entity
public class Cidade {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nome;
	
	private String estado;
	
	/**
	 *O atributo mappedBy foi utilizado para definir que a entidade pessoa é a
	 *dona do relacionamento, é a tabela pessoa que terá a chave estrangeira.
	 */
	@OneToMany(mappedBy = "cidade")
	private List<Pessoa> pessoas;
	
	private String cep;
	
	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
