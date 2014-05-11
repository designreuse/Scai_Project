package net.com.scaiprojectv.predicate;

import net.com.scaiprojectv.model.Aluno;
import net.com.scaiprojectv.model.QAluno;

import com.mysema.query.types.Predicate;

public class AlunoPredicate {

	public static Predicate buscarCPF(Aluno aluno) {
		QAluno condicao = QAluno.aluno;
		return condicao.cpf.equalsIgnoreCase(aluno.getCpf());
	}

}
