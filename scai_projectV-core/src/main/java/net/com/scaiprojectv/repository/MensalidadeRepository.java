package net.com.scaiprojectv.repository;

import net.com.scaiprojectv.model.Mensalidade;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface MensalidadeRepository extends
		JpaRepository<Mensalidade, Long>,
		QueryDslPredicateExecutor<Mensalidade> {

}
