package net.com.scaiprojectv.service.impl;

import java.util.List;

import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Service;

import com.mysema.query.types.Predicate;

import net.com.scaiprojectv.model.Matricula;
import net.com.scaiprojectv.model.Turma;
import net.com.scaiprojectv.repository.MatriculaRepository;
import net.com.scaiprojectv.service.MatriculaService;
import net.com.scaiprojectv.service.TurmaService;
import javassist.NotFoundException;

import javax.annotation.Resource;

@Service
public class MatriculaSerciveImpl implements MatriculaService {

	@Resource
	private MatriculaRepository matriculaRepository;
	
	@Resource
	private TurmaService turmaService;

	public List<Matricula> buscarTodos() {
		return matriculaRepository.findAll();
	}

	public List<Matricula> buscarTodos(Predicate condicao) {
		return (List<Matricula>) matriculaRepository.findAll(condicao);
	}

	public Matricula salvar(Matricula matricula) {
		return matriculaRepository.save(matricula);
	}

	public void excluir(Long id) {
		matriculaRepository.delete(id);
	}

	public Matricula buscarRegistro(Long id) {
		return matriculaRepository.findOne(id);

	}

	public Matricula buscarRegistro(Predicate condicao) {
		return matriculaRepository.findOne(condicao);
	}

	public Matricula salvarTurma(Matricula matricula) throws NotFoundException {
		Matricula matriculaRetorno = matriculaRepository.findOne(matricula.getId());
		Turma turmaRetorno = turmaService.buscarRegistro(matricula.getTurma().getId());
		

		if (matriculaRetorno == null) {
			throw new NotFoundException(
					"Não foi possível localizar matricula com ID ["
							+ matricula.getId() + "] !");
		}
		
		if (turmaRetorno == null) {
			throw new NotFoundException(
					"Não foi possível localizar turma com ID ["
							+ matricula.getId() + "] !");
		}

		turmaRetorno.setAlunosMatriculados(turmaRetorno.getAlunosMatriculados() + 1);
		matriculaRetorno.setTurma(turmaRetorno);

		return salvar(matriculaRetorno);
	}

}
