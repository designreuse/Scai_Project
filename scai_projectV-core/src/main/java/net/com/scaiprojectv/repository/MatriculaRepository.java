package net.com.scaiprojectv.repository;

import net.com.scaiprojectv.model.Matricula;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface MatriculaRepository extends JpaRepository<Matricula, Long>, QueryDslPredicateExecutor<Matricula>{

}
