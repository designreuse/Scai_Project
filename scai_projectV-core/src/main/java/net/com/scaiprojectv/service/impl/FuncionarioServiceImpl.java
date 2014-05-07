package net.com.scaiprojectv.service.impl;

import java.util.List;

import javassist.NotFoundException;

import javax.annotation.Resource;

import net.com.scaiprojectv.model.Funcionario;
import net.com.scaiprojectv.predicate.FuncionarioPredicate;
import net.com.scaiprojectv.repository.FuncionarioRepository;
import net.com.scaiprojectv.service.FuncionarioService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mysema.query.types.Predicate;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

	@Resource
	private FuncionarioRepository repository;

	@Transactional(readOnly = true)
	public List<Funcionario> buscarTodos() {
		return repository.findAll();
	}

	@Transactional(readOnly = true)
	public List<Funcionario> buscarTodos(Predicate condicao) {
		return (List<Funcionario>) repository.findAll(condicao);
	}

	@Transactional
	public Funcionario salvar(Funcionario funcionario) throws Exception {

		List<Funcionario> retorno = buscarTodos(FuncionarioPredicate.verificarUsuario(funcionario));

		if (retorno.size() > 0) {
			throw new Exception("Login [" + funcionario.getLogin() + "] ou CPF ["
					+ funcionario.getCpf() + "] existente na base de dados");
		}

		return repository.save(funcionario);
	}

	@Transactional(rollbackFor = NotFoundException.class)
	public void excluir(Long id) throws NotFoundException {
		Funcionario retorno = buscarRegistro(id);

		if (retorno == null) {
			throw new NotFoundException(
					"Não foi possivel localizar o funcionário com ID [" + id
							+ "]!");
		}

		repository.delete(retorno);

	}

	@Transactional(readOnly = true)
	public Funcionario buscarRegistro(Long funcionario)
			throws NotFoundException {
		Funcionario retorno = repository.findOne(funcionario);

		if (retorno == null) {
			throw new NotFoundException(
					"Não foi possível localizar o funcionário com ID ["
							+ funcionario + "");
		}

		return repository.findOne(funcionario);
	}

	@Transactional(readOnly = true)
	public Funcionario buscarRegistro(Predicate condicao) {
		return repository.findOne(condicao);
	}

}
