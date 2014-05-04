package net.com.scaiprojectv.repository;

import net.com.scaiprojectv.model.Turma;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface TurmaRepository extends JpaRepository<Turma, Long>, QueryDslPredicateExecutor<Turma>{

}
