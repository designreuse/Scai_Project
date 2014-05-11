package net.com.scaiprojectv.repository;

import net.com.scaiprojectv.model.Aluno;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface AlunoRepository extends JpaRepository<Aluno, Long>,
		QueryDslPredicateExecutor<Aluno> {

}
