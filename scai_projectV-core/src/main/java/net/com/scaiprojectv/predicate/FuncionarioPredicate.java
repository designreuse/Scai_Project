package net.com.scaiprojectv.predicate;

import net.com.scaiprojectv.model.Funcionario;
import net.com.scaiprojectv.model.QFuncionario;

import com.mysema.query.types.Predicate;
import com.mysema.query.types.expr.NumberExpression;

public class FuncionarioPredicate {

	public static Predicate buscarDocentes(){
		QFuncionario predicate = QFuncionario.funcionario;
		return predicate.cargo.eq("Docente");
	}
	
	public static NumberExpression<Long> verificarUsuario(Funcionario funcionaro){
		QFuncionario predicate = QFuncionario.funcionario;
		return predicate.login.equalsIgnoreCase(funcionaro.getNome()).count();
	}
}
