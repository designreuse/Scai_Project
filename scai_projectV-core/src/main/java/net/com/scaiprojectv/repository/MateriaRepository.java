package net.com.scaiprojectv.repository;

import net.com.scaiprojectv.model.Materia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface MateriaRepository extends JpaRepository<Materia, Long>, QueryDslPredicateExecutor<Materia>{

}
