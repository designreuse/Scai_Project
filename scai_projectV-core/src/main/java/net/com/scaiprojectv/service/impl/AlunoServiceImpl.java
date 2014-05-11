package net.com.scaiprojectv.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mysema.query.types.Predicate;

import javassist.NotFoundException;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.com.scaiprojectv.model.Aluno;
import net.com.scaiprojectv.model.Matricula;
import net.com.scaiprojectv.predicate.AlunoPredicate;
import net.com.scaiprojectv.repository.AlunoRepository;
import net.com.scaiprojectv.service.AlunoService;

@Service
public class AlunoServiceImpl implements AlunoService {

	@Resource
	private AlunoRepository repository;

	@Transactional(readOnly = true)
	public List<Aluno> buscarTodos() {
		return repository.findAll();
	}

	@Transactional(readOnly = true)
	public List<Aluno> buscarTodos(Predicate condicao) {
		return (List<Aluno>) repository.findAll(condicao);
	}

	@Transactional
	public Aluno salvar(Aluno aluno) throws Exception {
		Aluno retorno = buscarRegistro(AlunoPredicate.buscarCPF(aluno));

		if (retorno != null) {
			throw new Exception("O CPF [" + aluno.getCpf()
					+ "] já está registrado na base de dados!");
		}

		List<Matricula> matriculas = new ArrayList<Matricula>();
		Matricula matricula = new Matricula();
		matricula.setDataMatricula(new Date());
		matriculas.add(matricula);
		aluno.setMatriculas(matriculas);
		matricula.setAluno(aluno);
		return repository.save(aluno);

	}

	@Transactional(rollbackFor = NotFoundException.class)
	public void excluir(Long id) throws NotFoundException {
		Aluno retorno = buscarRegistro(id);

		if (retorno == null) {
			throw new NotFoundException(
					"Não foi possível localizar o registro com ID [" + id
							+ "] na base de dados");
		}

		repository.delete(retorno);

	}

	@Transactional(readOnly = true)
	public Aluno buscarRegistro(Long id) throws NotFoundException {
		Aluno retorno = repository.findOne(id);

		if (retorno == null) {
			throw new NotFoundException(
					"Não foi possível localizar o registro com ID [" + id
							+ "] na base de dados");
		}

		return retorno;

	}

	@Transactional(readOnly = true)
	public Aluno buscarRegistro(Predicate condicao) {
		return repository.findOne(condicao);
	}

}
