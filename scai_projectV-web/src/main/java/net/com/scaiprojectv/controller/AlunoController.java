/**
 * 
 */
package net.com.scaiprojectv.controller;

import java.math.BigDecimal;
import java.util.Date;

import javassist.NotFoundException;
import net.com.scaiprojectv.dto.Email;
import net.com.scaiprojectv.dto.GerarMensalidadesDTO;
import net.com.scaiprojectv.editor.CustomMateriaEditor;
import net.com.scaiprojectv.enumerator.TipoPagamentoEnum;
import net.com.scaiprojectv.model.Aluno;
import net.com.scaiprojectv.model.Matricula;
import net.com.scaiprojectv.model.Turma;
import net.com.scaiprojectv.pagseguro.PagamentoPagSeguro;
import net.com.scaiprojectv.service.AlunoService;
import net.com.scaiprojectv.service.MatriculaService;
import net.com.scaiprojectv.service.MensalidadeService;
import net.com.scaiprojectv.service.TurmaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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

	@Autowired
	private Email mail;
	
	@Autowired
	private TurmaService turmaService;

	@Autowired
	private MatriculaService matriculaService;

	@Autowired
	private AlunoService alunoService;

	@Autowired
	private MensalidadeService mensalidadeService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Matricula.class, new CustomMateriaEditor(
				matriculaService));
		binder.registerCustomEditor(Aluno.class, new StringTrimmerEditor(true));
	}

	@RequestMapping(value = "/aluno-curso")
	@ResponseBody
	public ModelAndView novoCurso() {
		ModelAndView view = new ModelAndView(RETURN_TURMA);
		mail.enviar();
		view.addObject("turmas", turmaService.buscarTodos());
		return view;
	}

	public ModelAndView cadastrarCurso() {
		ModelAndView view = new ModelAndView();

		return view;
	}

	@RequestMapping(value = "/aluno-novo/{idTurma}")
	public ModelAndView novoAluno(@PathVariable("idTurma") Long idTurma) {
		ModelAndView view = new ModelAndView(RETURN_NOVO_ALUNO);

		Aluno aluno = new Aluno();
		aluno.setId(idTurma);

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

	/**
	 * Classe que irá cadastrar Aluno > pagamento | Aluno > matricula |
	 * matricula > aluno Obs.: Primeiro é cadastrado aluno com a matricula,
	 * posteriormente, matricula com a turma.
	 * 
	 * @param aluno
	 * @param result
	 * @param redirect
	 * @return {@link ModelAndView}
	 */
	@RequestMapping(value = "/aluno-cadastrar", method = RequestMethod.POST)
	public ModelAndView cadastrarAluno(@ModelAttribute("aluno") Aluno aluno,
			BindingResult result, RedirectAttributes redirect) {
		ModelAndView view = new ModelAndView();
		Turma turma = new Turma();
		turma.setId(aluno.getId());

		Matricula matricula = new Matricula();
		matricula.setDataMatricula(new Date());
		matricula.setAluno(aluno);

		aluno.getMatriculas().add(matricula);
		aluno.setId(null);

		Aluno alunoRetorno = new Aluno();

		try {
			// cadastrar aluno > pagamento; aluno > matricula
			alunoRetorno = alunoService.salvar(aluno);
			matricula.setTurma(turma);

			// cadastrar matricula > turma
			Matricula matriculaRetorno = matriculaService
					.salvarTurma(matricula);

			if(aluno.getPagamento().getTipoPagamento().equals(TipoPagamentoEnum.PARCELAMENTO)){
			// cadastrar pagamento > mensalidade
			GerarMensalidadesDTO mensalidade = new GerarMensalidadesDTO(
					alunoRetorno.getPagamento().getQuantidadeParcela(),
					alunoRetorno.getPagamento().getDiaVencimento(),
					matriculaRetorno.getTurma().getValorCurso(), 
					alunoRetorno.getPagamento().getId());

			mensalidadeService.salvarMensalidades(mensalidade.gerarParcelas());
			//pagamento via pagseguro
			}else if(aluno.getPagamento().getTipoPagamento().equals(TipoPagamentoEnum.CARTAO)){
				PagamentoPagSeguro pagSeguro = new PagamentoPagSeguro(
						alunoRetorno.getPagamento().getId().toString(),
						"Matricula na escola de idiomas SCAI",
						1,
						new BigDecimal("100.00"));
				view = new ModelAndView("redirect:"+pagSeguro.gerarPagamento());
			}
			
		} catch (Exception e) {
			view = new ModelAndView(RETURN_TURMA);
			redirect.addFlashAttribute("msgType", "danger");
			redirect.addFlashAttribute("msg", e.getMessage());
			redirect.addFlashAttribute("aluno", aluno);
			System.out.println("mensagem: " + e.getMessage());
			return view;
		}
		return view;
	}

}
