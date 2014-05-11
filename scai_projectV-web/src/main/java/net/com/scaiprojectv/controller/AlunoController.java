/**
 * 
 */
package net.com.scaiprojectv.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javassist.NotFoundException;
import net.com.scaiprojectv.editor.CustomMateriaEditor;
import net.com.scaiprojectv.model.Aluno;
import net.com.scaiprojectv.model.Matricula;
import net.com.scaiprojectv.model.Turma;
import net.com.scaiprojectv.service.AlunoService;
import net.com.scaiprojectv.service.MatriculaService;
import net.com.scaiprojectv.service.TurmaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Comment(s):
 * 
 * @author Paulo Garcia
 * @Feb 19, 2014
 * @7:19:36 PM
 * 
 *          Scai Project_V®
 * 
 *          Developed by Paulo Garcia
 */
@Controller
public class AlunoController {

	private static final String RETURN_TURMA = "novo-turma";
	private static final String REDIRECT_NOVO_ALUNO = "redirect:/aluno-novo";
	private static final String REDIRECT_ALUNO_CURSO = "redirect:/aluno-curso";
	private static final String RETURN_NOVO_ALUNO = "novo-aluno";

	private Map<String, Matricula> matriculaCache = new HashMap<String, Matricula>();

	@Autowired
	private TurmaService turmaService;

	@Autowired
	private MatriculaService matriculaService;

	@Autowired
	private AlunoService alunoService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Matricula.class, new CustomMateriaEditor(
				matriculaService));
		binder.registerCustomEditor(Aluno.class, new StringTrimmerEditor(true));
	}

	@RequestMapping(value = "/aluno-curso")
	public ModelAndView novoCurso() {
		ModelAndView view = new ModelAndView(RETURN_TURMA);
		view.addObject("turmas", turmaService.buscarTodos());
		return view;
	}

	public ModelAndView cadastrarCurso() {
		ModelAndView view = new ModelAndView();

		return view;
	}

	@RequestMapping(value = "/aluno-novo")
	public ModelAndView novoAluno() {
		ModelAndView view = new ModelAndView(RETURN_NOVO_ALUNO);
		Aluno aluno = new Aluno();

		view.addObject("turmas", turmaService.buscarTodos());
		view.addObject("matriculas", matriculaService.buscarTodos());
		view.addObject("aluno", aluno);
		return view;
	}

	@RequestMapping(value = "/aluno-cadastrarturma/{idMatricula}/{idTurma}", method = RequestMethod.GET)
	public ModelAndView cadastrarAlunoNaTurma(
			@PathVariable("idMatricula") Long idMatricula,
			@PathVariable("idTurma") Long idTurma) throws NotFoundException {

		ModelAndView view = new ModelAndView();
		Matricula matricula = new Matricula();
		Turma turma = new Turma();

		turma.setId(idTurma);
		matricula.setId(idMatricula);
		matricula.setTurma(turma);
		turma.setMatricula(matricula);
		
		matriculaService.salvarTurma(matricula);

		return view;
	}

	@RequestMapping(value = "/aluno-cadastrar", method = RequestMethod.POST)
	public ModelAndView cadastrarAluno(@ModelAttribute("aluno") Aluno aluno,
			BindingResult result, RedirectAttributes redirect) {
		ModelAndView view = new ModelAndView(RETURN_TURMA);

		Matricula matricula = new Matricula();
		matricula.setDataMatricula(new Date());
		Aluno retorno = new Aluno();

		try {
			retorno = alunoService.salvar(aluno);
		} catch (Exception e) {
			view = new ModelAndView(REDIRECT_NOVO_ALUNO);
			redirect.addFlashAttribute("msgType", "danger");
			redirect.addFlashAttribute("msg", e.getMessage());
			redirect.addFlashAttribute("aluno", aluno);
			return view;
		}

		view.addObject("idMatricula", retorno.getMatriculas().get(0).getId());
		view.addObject("turmas", turmaService.buscarTodos());
		view.addObject("matricula", new Matricula());
		return view;
	}

}
