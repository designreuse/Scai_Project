package net.com.scaiprojectv.service.impl;

import java.util.List;

import javax.annotation.Resource;

import net.com.scaiprojectv.model.Turma;
import net.com.scaiprojectv.repository.TurmaRepository;
import net.com.scaiprojectv.service.TurmaService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mysema.query.types.Predicate;

@Service
public class TurmaServiceImpl implements TurmaService {

	@Resource
	private TurmaRepository repository;

	public Turma cadastrar(Turma turma) {
		return repository.save(turma);
	}

	public List<Turma> buscarTodos() {
		return repository.findAll();
	}

	public List<Turma> buscarTodos(Predicate condicao) {
		return (List<Turma>) repository.findAll(condicao);
	}

	public void excluir(Long id) {
		repository.delete(id);

	}

	@Transactional(readOnly=true)
	public Turma buscarRegistro(Long id) {
		return repository.findOne(id);
	}

	public Turma buscarRegistro(Predicate condicao) {
		return repository.findOne(condicao);
	}

}
