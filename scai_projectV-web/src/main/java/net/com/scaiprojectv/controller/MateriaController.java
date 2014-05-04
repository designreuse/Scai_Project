package net.com.scaiprojectv.controller;

import net.com.scaiprojectv.model.Materia;
import net.com.scaiprojectv.service.MateriaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MateriaController {
	
	private static final String RETURN_NOVA_MATERIA = "novo-materia";
	private static final String RETURN_GERENCIAR = "gerenciar-materia";

	@Autowired
	private MateriaService materiaService;
	
	@RequestMapping(value = "/materia-novo")
	public ModelAndView index(){
		ModelAndView view = new ModelAndView(RETURN_NOVA_MATERIA);
		
		view.addObject("materia", new Materia());
		
		return view;
	}
	
	@RequestMapping(value = "/materia-cadastrar", method = RequestMethod.POST)
	public ModelAndView cadastrar(@ModelAttribute("materia") Materia materia, BindingResult bind){
		ModelAndView view = new ModelAndView(RETURN_NOVA_MATERIA);
		
		view.addObject("materia", new Materia());
		materia.setStatus(true);
		materiaService.salvar(materia);
		
		return view;
	}
	
	@RequestMapping(value = "materia-gerenciar")
	public ModelAndView gerenciar(){
		ModelAndView view = new ModelAndView(RETURN_GERENCIAR);
		view.addObject("materias", materiaService.buscarTodos());
		return view;
	}
	
}
