package net.com.scaiprojectv.service.impl;

import java.util.List;

import javax.annotation.Resource;

import net.com.scaiprojectv.model.Funcionario;
import net.com.scaiprojectv.repository.FuncionarioRepository;
import net.com.scaiprojectv.service.FuncionarioService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mysema.query.types.Predicate;

@Service
public class FuncionarioServiceImpl implements FuncionarioService{

	@Resource
	private FuncionarioRepository repository;
	
	public List<Funcionario> buscarTodos() {
		return repository.findAll();
	}

	public List<Funcionario> buscarTodos(Predicate condicao) {
		return (List<Funcionario>) repository.findAll(condicao);
	}

	@Transactional(readOnly = false)  
	public Funcionario salvar(Funcionario funcionario) {
		return repository.save(funcionario);
	}

	public void excluir(Long id) {
		repository.delete(id);
	}

	public Funcionario buscarRegistro(Long funcionario) {
		return repository.findOne(funcionario);
	}

	public Funcionario buscarRegistro(Predicate condicao) {
		return repository.findOne(condicao);
	}
	
}
