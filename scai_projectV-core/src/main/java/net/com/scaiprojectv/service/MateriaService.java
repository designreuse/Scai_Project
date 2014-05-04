package net.com.scaiprojectv.service;

import java.util.List;

import net.com.scaiprojectv.model.Materia;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mysema.query.types.Predicate;

public interface MateriaService {

	List<Materia> buscarTodos();
	
	List<Materia> buscarTodos(Predicate condicao);
	
	Materia salvar(Materia materia);
	
	void excluir(Long idMateria);
	
	Materia buscarRegistro(Long id);
	
	Materia buscarRegistro(Predicate condicao);
	
}
