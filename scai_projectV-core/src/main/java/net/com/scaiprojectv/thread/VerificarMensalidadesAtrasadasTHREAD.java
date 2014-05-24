package net.com.scaiprojectv.thread;

import java.util.List;

import net.com.scaiprojectv.model.Aluno;
import net.com.scaiprojectv.service.AlunoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class VerificarMensalidadesAtrasadasTHREAD {

	@Autowired
	private AlunoService alunoService;

	/**
	 * A cron-like expression, extending the usual UN*X definition to include
	 * triggers on the second as well as minute, hour, day of month, month and
	 * day of week. e.g. "0 * * * * MON-FRI" means once per minute on weekdays
	 * (at the top of the minute - the 0th second).
	 */
	@Scheduled(cron = "*/30 1 * * * ?")
	private void verificarMensalidades() {
		List<Aluno> alunos = alunoService.buscarTodos();

		for (Aluno aluno : alunos) {
			System.out.println("Aluno: " + aluno.getNome());
		}
	}

}
