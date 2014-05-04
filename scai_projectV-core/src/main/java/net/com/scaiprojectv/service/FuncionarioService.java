package net.com.scaiprojectv.service;

import java.util.List;

import net.com.scaiprojectv.model.Funcionario;

import com.mysema.query.types.Predicate;

public interface FuncionarioService {

	List<Funcionario> buscarTodos();
	
	List<Funcionario> buscarTodos(Predicate condicao);
	
	Funcionario salvar(Funcionario funcionario);
	
	void excluir(Long id);
	
	Funcionario buscarRegistro(Long id);
	
	Funcionario buscarRegistro(Predicate condicao);
}
