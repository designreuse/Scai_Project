package net.com.scaiprojectv.service;

import java.util.List;

import javax.activity.InvalidActivityException;

import javassist.NotFoundException;
import net.com.scaiprojectv.model.Funcionario;

import com.mysema.query.types.Predicate;

public interface FuncionarioService {

	List<Funcionario> buscarTodos();
	
	List<Funcionario> buscarTodos(Predicate condicao);
	
	Funcionario salvar(Funcionario funcionario) throws Exception;
	
	void excluir(Long id) throws NotFoundException;
	
	Funcionario buscarRegistro(Long id) throws NotFoundException;
	
	Funcionario buscarRegistro(Predicate condicao);
}
