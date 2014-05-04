/**
 * 
 */
package net.com.scaiprojectv.controller;

import java.util.List;

import net.com.scaiprojectv.model.Aluno;
import net.com.scaiprojectv.model.Pessoa;
import net.com.scaiprojectv.predicate.PessoaPredicate;
import net.com.scaiprojectv.service.PessoaService;
import net.com.scaiprojectv.service.TurmaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Comment(s): 
 * 
 * @author Paulo Garcia
 * @Feb 19, 2014
 * @7:19:36 PM
 *
 * Scai Project_V®
 *
 * Developed by Paulo Garcia
 */
@Controller
public class AlunoController {

	private static final String RETURN_NOVO_ALUNO = "novo-aluno";
	
	@Autowired
	private TurmaService turmaService;
	
	@RequestMapping(value = "/aluno-novo")
	public ModelAndView novo(){
		ModelAndView view = new ModelAndView(RETURN_NOVO_ALUNO);
		view.addObject("aluno", new Aluno());
		view.addObject("turmas", turmaService.buscarTodos());
		return view;
	}
	
}
