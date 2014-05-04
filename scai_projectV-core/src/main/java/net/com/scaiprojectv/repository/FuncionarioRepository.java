package net.com.scaiprojectv.repository;

import net.com.scaiprojectv.model.Funcionario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>, QueryDslPredicateExecutor<Funcionario>{

}
