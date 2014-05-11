package net.com.scaiprojectv.service;

import java.util.List;

import javassist.NotFoundException;

import com.mysema.query.types.Predicate;

import net.com.scaiprojectv.model.Aluno;

public interface AlunoService {

	/**
	 * Método de busca de todos os registros na base de dados
	 * 
	 * @return {@link List}
	 */
	List<Aluno> buscarTodos();

	/**
	 * Métodos de busca de todos os registro com condição
	 * 
	 * @param condicao
	 * @return {@link List}
	 */
	List<Aluno> buscarTodos(Predicate condicao) throws NotFoundException;

	/**
	 * Método de salvar novo registro no banco de dados
	 * 
	 * @param aluno
	 * @return Aluno
	 */
	Aluno salvar(Aluno aluno) throws Exception;

	/**
	 * Método para remover registro na base de dados
	 * 
	 * @param id
	 */
	void excluir(Long id)throws Exception;

	/**
	 * Método de busca de registro pelo identificador
	 * 
	 * @param id
	 * @return {@link Aluno}
	 */
	Aluno buscarRegistro(Long id)throws NotFoundException;

	/**
	 * Método de busca de registro com condicao
	 * 
	 * @param condicao
	 * @return {@link Aluno}
	 */
	Aluno buscarRegistro(Predicate condicao)throws NotFoundException;
}
