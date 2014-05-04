/**
 * 
 */
package net.com.scaiprojectv.predicate;

import com.mysema.query.types.Predicate;

import net.com.scaiprojectv.model.QPessoa;

/**
 * Comment(s): Classe predicate de Pessoa
 * 
 * @author Paulo Garcia
 * @Mar 19, 2014
 * @8:06:41 PM
 * 
 *          Scai Project_V®
 * 
 *          Developed by Paulo Garcia
 */
public class PessoaPredicate {

	public static Predicate buscarPorNome(String nome) {
		QPessoa condicao = QPessoa.pessoa;
		return condicao.nome.eq(nome);
	}

	public static Predicate buscarPorId(Long id){
		QPessoa condicao = QPessoa.pessoa;
		return null;
	}
	
}
