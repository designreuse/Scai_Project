package net.com.scaiprojectv.service;

import java.util.List;

import javassist.NotFoundException;

import org.springframework.transaction.annotation.Transactional;

import net.com.scaiprojectv.model.Turma;

import com.mysema.query.types.Predicate;

public interface TurmaService {

	List<Turma> buscarTodos();
	
	List<Turma> buscarTodos(Predicate condicao);
	
	Turma cadastrar(Turma turma);
	
	Turma cadastrarTurmaMatricula(Turma turma) throws NotFoundException;
	
	void excluir (Long id);
	
	Turma buscarRegistro(Long id);
	
	Turma buscarRegistro(Predicate condicao);
	
}
