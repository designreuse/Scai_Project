package net.com.scaiprojectv.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import net.com.scaiprojectv.enumerator.AcessoSistemaEnum;
import net.com.scaiprojectv.enumerator.TipoFuncionario;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

@Entity
@PrimaryKeyJoinColumn(name = "id_pessoa")
public class Funcionario extends Pessoa {

	private String cargo;

	private String login;

	private String senha;
	
	@Enumerated(EnumType.STRING)
	private AcessoSistemaEnum acessoSistema;
	
	@Temporal(TemporalType.DATE)
	private Date dataAdmissao;
	
	private Double salario;
	
	@ManyToMany
	private List<Materia> materia = new ArrayList<Materia>();
	
	private Short diaVencimentoSalario;
	
	@Enumerated(EnumType.STRING)
	private TipoFuncionario tpFuncionario;
	

	
	public List<Materia> getMateria() {
		return materia;
	}

	public void setMateria(List<Materia> materia) {
		this.materia = materia;
	}

	public TipoFuncionario getTpFuncionario() {
		return tpFuncionario;
	}

	public void setTpFuncionario(TipoFuncionario tpFuncionario) {
		this.tpFuncionario = tpFuncionario;
	}

	public Date getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public Short getDiaVencimentoSalario() {
		return diaVencimentoSalario;
	}

	public void setDiaVencimentoSalario(Short diaVencimentoSalario) {
		this.diaVencimentoSalario = diaVencimentoSalario;
	}

	public AcessoSistemaEnum getAcessoSistema() {
		return acessoSistema;
	}

	public void setAcessoSistema(AcessoSistemaEnum acessoSistema) {
		this.acessoSistema = acessoSistema;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
