package net.com.scaiprojectv.service;

import java.util.List;

import javassist.NotFoundException;

import com.mysema.query.types.Predicate;

import net.com.scaiprojectv.model.Matricula;

public interface MatriculaService {

	List<Matricula> buscarTodos();

	List<Matricula> buscarTodos(Predicate condicao);

	Matricula salvar(Matricula matricula);

	Matricula salvarTurma(Matricula matricula) throws NotFoundException;

	void excluir(Long id);

	Matricula buscarRegistro(Long id);

	Matricula buscarRegistro(Predicate condicao);

}
