/**
 * 
 */
package net.com.scaiprojectv.repository;

import net.com.scaiprojectv.model.Pessoa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 * Comment(s): Interface de aluno repository.
 * 
 * @author Paulo Garcia
 * @Feb 19, 2014
 * @5:20:29 PM
 *
 * Scai Project_V®
 *
 * Developed by Paulo Garcia
 */
public interface PessoaRepository extends JpaRepository<Pessoa, Long>, QueryDslPredicateExecutor<Pessoa>{

}
