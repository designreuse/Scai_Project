package net.com.scaiprojectv.controller;

import java.util.ArrayList;
import java.util.List;

import javassist.NotFoundException;

import javax.servlet.http.HttpServletRequest;

import net.com.scaiprojectv.model.Aluno;
import net.com.scaiprojectv.model.Pessoa;
import net.com.scaiprojectv.predicate.PessoaPredicate;
import net.com.scaiprojectv.service.AlunoService;
import net.com.scaiprojectv.service.PessoaService;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DashboardController {

	private static final String RETURN_DASHBOARD = "dashboard";

	@Autowired
	private PessoaService pessoaService;
	
	@Autowired
	private AlunoService alunoService;
	
	@RequestMapping(value = "/dashboard")
	public ModelAndView index() throws NotFoundException {
		ModelAndView view = new ModelAndView(RETURN_DASHBOARD);
		List<Aluno> alunosMatriculasdos = new ArrayList<Aluno>();
		alunosMatriculasdos = alunoService.buscarTodosPorMesAtual();
		view.addObject("alunosMatriculados", alunosMatriculasdos.size());
		return view;
	}

	@RequestMapping(value = "/dashboard-find", produces = "application/json")
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody
	String ajax(HttpServletRequest request) throws JSONException {
		JSONObject sugestoes = new JSONObject();
		sugestoes.put("query", request.getParameter("query"));

		List<Pessoa> pessoas = pessoaService.buscarTodos(PessoaPredicate
				.todosCadastrado(request.getParameter("query")));

		for (Pessoa pessoa : pessoas) {
			sugestoes.append("suggestions", pessoa.getNome());
		}

		String json_string = sugestoes.toString();
		return json_string;
	}
	
}
