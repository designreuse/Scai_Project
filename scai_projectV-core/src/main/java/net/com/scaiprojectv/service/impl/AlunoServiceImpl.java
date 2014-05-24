package net.com.scaiprojectv.service.impl;

import java.util.Calendar;
import java.util.List;

import javassist.NotFoundException;

import javax.annotation.Resource;

import net.com.scaiprojectv.enumerator.TipoPagamentoEnum;
import net.com.scaiprojectv.model.Aluno;
import net.com.scaiprojectv.predicate.AlunoPredicate;
import net.com.scaiprojectv.repository.AlunoRepository;
import net.com.scaiprojectv.service.AlunoService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mysema.query.types.Predicate;

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

	@Transactional(readOnly = true)
	public List<Aluno> buscarTodosPorMesAtual() throws NotFoundException {
		Calendar dataInicioMes = Calendar.getInstance();
		Calendar dataAtual = Calendar.getInstance();
		dataInicioMes.set(Calendar.DAY_OF_MONTH, 1);

		return (List<Aluno>) repository.findAll(AlunoPredicate
				.buscarAlunosCadastradoMesAtual(dataInicioMes, dataAtual));
	}

	@Transactional
	public Aluno salvar(Aluno aluno) throws Exception {
		Aluno retorno = buscarRegistro(AlunoPredicate.buscarCPF(aluno));

		if (retorno != null) {
			throw new Exception("O CPF [" + aluno.getCpf()
					+ "] já está registrado na base de dados!");
		}

		if (aluno.getPagamento().getTipoPagamento()
				.equals(TipoPagamentoEnum.A_VISTA)) {
			aluno.getPagamento().setQuantidadeParcela(0);
			aluno.getPagamento().setDiaVencimento(0);
		}

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
