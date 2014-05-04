package net.com.scaiprojectv.service.impl;

import java.util.List;

import com.mysema.query.types.Predicate;

import net.com.scaiprojectv.model.Materia;
import net.com.scaiprojectv.repository.MateriaRepository;
import net.com.scaiprojectv.service.MateriaService;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service
public class MateriaServiceImpl implements MateriaService {

	@Resource
	private MateriaRepository repository;

	public List<Materia> buscarTodos() {
		return repository.findAll();
	}

	public List<Materia> buscarTodos(Predicate condicao) {
		return (List<Materia>) repository.findAll(condicao);
	}

	public Materia salvar(Materia materia) {
		return repository.save(materia);
	}

	public void excluir(Long idMateria) {
		repository.delete(idMateria);
	}

	public Materia buscarRegistro(Long id) {
		return repository.findOne(id);
	}

	public Materia buscarRegistro(Predicate condicao) {
		return repository.findOne(condicao);
	}

}
