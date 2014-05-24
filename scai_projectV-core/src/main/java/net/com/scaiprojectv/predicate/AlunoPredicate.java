package net.com.scaiprojectv.predicate;

import java.util.Calendar;
import java.util.Date;

import net.com.scaiprojectv.model.Aluno;
import net.com.scaiprojectv.model.QAluno;

import com.mysema.query.types.Predicate;

public class AlunoPredicate {

	public static Predicate buscarCPF(Aluno aluno) {
		QAluno condicao = QAluno.aluno;
		return condicao.cpf.equalsIgnoreCase(aluno.getCpf());
	}

	public static Predicate buscarAlunosCadastradoMesAtual(Calendar dataInicio,
			Calendar dataAtual) {
		QAluno condicao = QAluno.aluno;
//		return condicao.dataCadastro.between(dataInicio.getTime(), new Date());
		return null;
	}

}
