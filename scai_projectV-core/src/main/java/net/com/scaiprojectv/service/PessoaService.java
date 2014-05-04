/**
 * 
 */
package net.com.scaiprojectv.service;

import java.util.List;

import com.mysema.query.types.Predicate;

import net.com.scaiprojectv.model.Pessoa;


/**
 * Comment(s): Declaração de métodos usados para obter e modificar informações de "Aluno". 
 * 
 * @author Paulo Garcia
 * @Feb 8, 2014
 * @4:18:43 PM
 *
 * Scai Project_V®
 *
 * Developed by Paulo Garcia
 */
public interface PessoaService {

	/**
	 * Método responsável por salvar uma entidade "aluno" na base de dados.
	 * @param aluno
	 * @return {@link Pessoa}
	 */
	Pessoa criar(Pessoa aluno);
	
	/**
	 * Método responsável por remover um registro de "aluno" na base de dados.
	 * @param id
	 * @return {@link Pessoa}
	 */
	Pessoa remover(Long id);
	
	/**
	 * Métodos responsável por localizar todos os registros de "aluno" na base de dados.
	 * @return List<Aluno>
	 */
	List<Pessoa>buscarTodos(Predicate condicao);
	
	/**
	 * Métodos responsável por localizar todos os registros de "aluno" na base de dados.
	 * @return List<Aluno>
	 */
	List<Pessoa>buscarTodos();
	
	/**
	 * Método responsável por localizar "Aluno" por ID.
	 * @return {@link Pessoa}
	 */
	Pessoa buscarPorId(Long id);
	
}
