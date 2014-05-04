/**
 * 
 */
package net.com.scaiprojectv.controller;

import net.com.scaiprojectv.model.Pessoa;
import net.com.scaiprojectv.service.PessoaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Comment(s): 
 * 
 * @author Paulo Garcia
 * @Feb 7, 2014
 * @11:36:30 PM
 *
 * Scai Project_V®
 *
 * Developed by Paulo Garcia
 */
@Controller
@RequestMapping(value = "/teste")
public class ControllerTeste{

	@Autowired
	private PessoaService alunoService;
	
	@RequestMapping(value = "")
	public ModelAndView index(){
		ModelAndView view = new ModelAndView("index");
		return view;
	}
	
}
