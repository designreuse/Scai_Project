package net.com.scaiprojectv.controller;

import javassist.NotFoundException;
import net.com.scaiprojectv.enumerator.TipoFuncionario;
import net.com.scaiprojectv.model.Funcionario;
import net.com.scaiprojectv.service.FuncionarioService;
import net.com.scaiprojectv.service.MateriaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class FuncionarioController {

	private static final String RETURN_NOVO_AUXILIAR = "novo-auxiliar";
	private static final String RETURN_GERENCIAR_AUXILIAR = "gerenciar-auxiliar";
	private static final String RETURN_NOVO_DOCENTE = "novo-docente";
	private static final String REDIRECT_NOVO_AUXILIAR = "redirect:/funcionario-novo-auxiliar";

	@Autowired
	private FuncionarioService funcionarioService;

	@Autowired
	private MateriaService materiaService;
	
	@RequestMapping(value = "/funcionario-novo-auxiliar")
	public ModelAndView novoAuxiliar() {
		ModelAndView view = new ModelAndView(RETURN_NOVO_AUXILIAR);

		view.addObject("materias", materiaService.buscarTodos());
		view.addObject("docente", new Funcionario());

		return view;
	}

	
	@RequestMapping(value = "/funcionario-cradastrar-auxiliar", method = RequestMethod.POST)
	public ModelAndView cadastrarAuxiliar(
			@ModelAttribute("docente") Funcionario funcionario,
			BindingResult binding, RedirectAttributes redirect) {
		ModelAndView view = new ModelAndView(RETURN_NOVO_AUXILIAR);

		funcionario.setTpFuncionario(TipoFuncionario.INTERNO);
		
		try{
			funcionarioService.salvar(funcionario);
		}catch(Exception e){
			view = new ModelAndView(REDIRECT_NOVO_AUXILIAR);
			redirect.addFlashAttribute("funcionario", funcionario);
			redirect.addFlashAttribute("msgType", "danger");
			redirect.addFlashAttribute("msg", e.getMessage());
			return view;
		}
		
		view.addObject("docente", new Funcionario());

		return view;
	}
	
	@RequestMapping(value = "/funcionario-gerenciar-auxiliar")
	public ModelAndView garenciarAuxiliar(){
		ModelAndView view = new ModelAndView(RETURN_GERENCIAR_AUXILIAR);
		
		view.addObject("funcionarios", funcionarioService.buscarTodos());
		
		return view;
	}
	
	@RequestMapping(value = "/funcionario-novo-docente")
	public ModelAndView novoDocente() {
		ModelAndView view = new ModelAndView(RETURN_NOVO_DOCENTE);

		view.addObject("materias", materiaService.buscarTodos());
		view.addObject("docente", new Funcionario());		

		return view;
	}

	
	@RequestMapping(value = "/funcionario-cradastrar-docente", method = RequestMethod.POST)
	public ModelAndView cadastrarDocente(
			@ModelAttribute("docente") Funcionario funcionario,
			BindingResult binding) throws Exception {
		ModelAndView view = new ModelAndView(RETURN_NOVO_AUXILIAR);

		funcionario.setTpFuncionario(TipoFuncionario.DOCENTE);
		funcionarioService.salvar(funcionario);
		view.addObject("docente", new Funcionario());

		return view;
	}

}
