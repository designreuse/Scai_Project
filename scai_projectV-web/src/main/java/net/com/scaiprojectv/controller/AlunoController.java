/**
 * 
 */
package net.com.scaiprojectv.controller;

import java.util.Date;
import java.util.List;

import javassist.NotFoundException;
import net.com.scaiprojectv.dto.GerarMensalidadesDTO;
import net.com.scaiprojectv.dto.SendEmailDTO;
import net.com.scaiprojectv.editor.CustomMateriaEditor;
import net.com.scaiprojectv.enumerator.StatusPagamento;
import net.com.scaiprojectv.enumerator.TipoPagamentoEnum;
import net.com.scaiprojectv.model.Aluno;
import net.com.scaiprojectv.model.Matricula;
import net.com.scaiprojectv.model.Mensalidade;
import net.com.scaiprojectv.model.Pagamento;
import net.com.scaiprojectv.model.Turma;
import net.com.scaiprojectv.pagseguro.PagamentoPagSeguro;
import net.com.scaiprojectv.predicate.MensalidadePredicate;
import net.com.scaiprojectv.service.AlunoService;
import net.com.scaiprojectv.service.MatriculaService;
import net.com.scaiprojectv.service.MensalidadeService;
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
public class AlunoController{

	private static final String RETURN_TURMA = "novo-turma";
	private static final String REDIRECT_NOVO_ALUNO = "redirect:/aluno-novo";
	private static final String REDIRECT_ALUNO_CURSO = "redirect:/aluno-curso";
	private static final String RETURN_NOVO_ALUNO = "novo-aluno";
	private static final String RETURN_DASHBOARD = "redirect:/dashboard";
	private static final String RETURN_EDITAR = "editar-aluno";
	private static final String RETURN_MENSALIDADES_ALUNO = "mensalidade-aluno";
	private static final String REDIRECT_MENSALIDADES = "redirect:/aluno-mensalidades/";

	@Autowired
	private SendEmailDTO mail;

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
		view.addObject("turmas", turmaService.buscarTodos());
		return view;
	}

	public ModelAndView cadastrarCurso() {
		ModelAndView view = new ModelAndView();

		return view;
	}

	@RequestMapping(value = "/aluno-novo/{idTurma}")
	public ModelAndView novoAluno(@PathVariable("idTurma") Long idTurma,
			RedirectAttributes redirect) {
		ModelAndView view = new ModelAndView(RETURN_NOVO_ALUNO);
		redirect.getFlashAttributes();
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
		ModelAndView view = new ModelAndView(RETURN_DASHBOARD);
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

			if (aluno.getPagamento().getTipoPagamento()
					.equals(TipoPagamentoEnum.PARCELAMENTO)) {
				// cadastrar pagamento > mensalidade
				GerarMensalidadesDTO mensalidade = new GerarMensalidadesDTO(
						alunoRetorno.getPagamento().getQuantidadeParcela(),
						alunoRetorno.getPagamento().getDiaVencimento(),
						matriculaRetorno.getTurma().getValorCurso(),
						alunoRetorno.getPagamento().getId());

				mensalidadeService.salvarMensalidades(mensalidade
						.gerarParcelas());
				// pagamento via pagseguro
			} else if (aluno.getPagamento().getTipoPagamento()
					.equals(TipoPagamentoEnum.CARTAO)) {
				turma = turmaService.buscarRegistro(turma.getId());
				PagamentoPagSeguro pagSeguro = new PagamentoPagSeguro(
						alunoRetorno, turma, 1);

				mail.enviar(alunoRetorno, pagSeguro.gerarPagamento());
				mensalidadeService.salvarMensalidade(setMensalidade(turma,
						alunoRetorno, StatusPagamento.PAGAMENTO_TOTAL));
				// pagamento a vista
			} else if (aluno.getPagamento().getTipoPagamento()
					.equals(TipoPagamentoEnum.A_VISTA)) {
				mensalidadeService.salvarMensalidade(setMensalidade(turma,
						alunoRetorno, StatusPagamento.PAGAMENTO_TOTAL));
			}

		} catch (Exception e) {
			view = new ModelAndView(RETURN_NOVO_ALUNO);
			aluno.setId(turma.getId());
			view.addObject("msgType", "danger");
			view.addObject("msg", e.getMessage());
			view.addObject("aluno", aluno);
			return view;
		}

		redirect.addFlashAttribute("msgType", "success");
		redirect.addFlashAttribute("msg", "Registro inserido com sucesso");

		return view;
	}

	private Mensalidade setMensalidade(Turma turma, Aluno aluno,
			StatusPagamento status) {
		turma = turmaService.buscarRegistro(turma.getId());
		Mensalidade mensalidade = new Mensalidade();
		Pagamento pagamento = new Pagamento();
		mensalidade.setStatusPagamento(status);
		mensalidade.setValorPago(turma.getValorCurso());
		pagamento.setId(aluno.getPagamento().getId());
		mensalidade.setPagamento(pagamento);
		return mensalidade;
	}

	@RequestMapping(value = "aluno-editar/{idAluno}")
	public ModelAndView editar(@PathVariable("idAluno") Long idAluno) {
		ModelAndView view = new ModelAndView(RETURN_EDITAR);

		try {
			view.addObject("aluno", alunoService.buscarRegistro(idAluno));
		} catch (NotFoundException e) {
			view = new ModelAndView(RETURN_DASHBOARD);
			view.addObject("msgType", "danger");
			view.addObject("msg", e.getMessage());
		}

		return view;
	}

	@RequestMapping(value = "/aluno-mensalidades/{idAluno}")
	public ModelAndView mensalidades(@PathVariable("idAluno") Long idAluno) {
		ModelAndView view = new ModelAndView(RETURN_MENSALIDADES_ALUNO);
		try {
			Aluno retorno = alunoService.buscarRegistro(idAluno);
			view.addObject("aluno", retorno);
			List<Mensalidade> mensalidades = mensalidadeService
					.buscarTodos(MensalidadePredicate
							.buscarMensalidadesPorPagamento(retorno
									.getPagamento().getId()));
			view.addObject("mensalidades", mensalidades);

		} catch (NotFoundException e) {
			e.printStackTrace();
		}
		return view;
	}

	/**
	 * Método responsável por alterar o status da mensalidade
	 * 
	 * @param idMensalidade
	 * @param idAluno
	 * @param result
	 * @param redirect
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/aluno-receber-mensalidade/{idMensalidade}/{idAluno}")
	public ModelAndView receberMensalidade(
			@PathVariable("idMensalidade") Long idMensalidade,
			@PathVariable("idAluno") Long idAluno, RedirectAttributes redirect){

		ModelAndView view = new ModelAndView(REDIRECT_MENSALIDADES + idAluno);
		
		try{
		Mensalidade mensalidade = mensalidadeService
				.buscarRegistro(idMensalidade);

		mensalidade.setStatusPagamento(StatusPagamento.PAGO);

		mensalidadeService.salvarMensalidade(mensalidade);
		}catch(Exception e){
			redirect.addFlashAttribute("msgType", "danger");
			redirect.addFlashAttribute("msg","Erro ao receber mensalidade: " + e.getMessage());
		}
		
		redirect.addFlashAttribute("msgType", "success");
		redirect.addFlashAttribute("msg","Mensalidade recebida com sucesso!");
		return view;
	}

}
