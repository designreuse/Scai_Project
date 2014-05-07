package net.com.scaiprojectv.controller;

import net.com.scaiprojectv.model.Turma;
import net.com.scaiprojectv.service.MateriaService;
import net.com.scaiprojectv.service.TurmaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TurmaController{

	private static final String RETURN_NOVO_TURMA = "turma-novo";
	private static final String RETURN_GERENCIAR_TURMA = "turma-gerenciar";
	private static final String RETURN_EDITAR_TURMA = "turma-editar";
	
	@Autowired
	private MateriaService materiaService;
	
	@Autowired 
	private TurmaService turmaService;
	
	@RequestMapping(value = "/turma-novo")
	public ModelAndView novo(){
		ModelAndView view = new ModelAndView(RETURN_NOVO_TURMA);
		view.addObject("materias", materiaService.buscarTodos());
		view.addObject("turma", new Turma());
		return view;
	}
	
	@RequestMapping(value = "/cadastrar-turma", method = RequestMethod.POST, produces = "application/json")
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody void cadastrarTurma(@RequestBody Turma turma){
		turma.setAlunosMatriculados(0);
		turmaService.cadastrar(turma);
	}
	
	@RequestMapping(value = "/gerenciar-turma")
	public ModelAndView gerenciarTurma(){
		ModelAndView view = new ModelAndView(RETURN_GERENCIAR_TURMA);
		view.addObject("turmas", turmaService.buscarTodos());
		return view;
	}
	
	@RequestMapping(value = "/removerTurma/{id}", method = RequestMethod.POST, produces = "application/json")
	@ResponseStatus(value = HttpStatus.OK)
	public void removerTurma(@PathVariable Long id){
		turmaService.excluir(id);
	}
	
	@RequestMapping(value = "/editar-turma/{id}")
	public ModelAndView editar(@PathVariable Long id){
		ModelAndView view = new ModelAndView(RETURN_EDITAR_TURMA);
		view.addObject("materias", materiaService.buscarTodos());
		view.addObject("turma", turmaService.buscarRegistro(id));
		return view;
	}
	
}

