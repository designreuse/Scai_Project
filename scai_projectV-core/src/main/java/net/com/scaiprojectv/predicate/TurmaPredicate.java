package net.com.scaiprojectv.predicate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import net.com.scaiprojectv.model.QTurma;
import net.com.scaiprojectv.model.Turma;

import com.mysema.query.types.Predicate;

public class TurmaPredicate {

	
	public static Predicate buscarDocentes(){
		QTurma predicate = QTurma.turma;
		return null;
	}
	
}
