package net.com.scaiprojectv.controller;

import javax.servlet.http.HttpServletRequest;

import net.com.scaiprojectv.predicate.PessoaPredicate;
import net.com.scaiprojectv.service.PessoaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PessoaController {

	private static final String RETURN_PESSOA = "pessoas";
	
	@Autowired
	private PessoaService pessoaService;
	
	@RequestMapping(value = "/pessoa-pesquisar", method = RequestMethod.GET)
	public ModelAndView index(HttpServletRequest request){
		ModelAndView view = new ModelAndView(RETURN_PESSOA);
		view.addObject("pessoas",pessoaService.buscarTodos(PessoaPredicate.todosCadastrado(request.getParameter("query").toLowerCase())));
		return view;
	}
	
}
