package net.com.scaiprojectv.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import net.com.scaiprojectv.model.Turma;

import com.mysema.query.types.Predicate;

public interface TurmaService {

	List<Turma> buscarTodos();
	
	List<Turma> buscarTodos(Predicate condicao);
	
	Turma cadastrar(Turma turma);
	
	void excluir (Long id);
	
	@Transactional(readOnly=true)
	Turma buscarRegistro(Long id);
	
	Turma buscarRegistro(Predicate condicao);
	
}
