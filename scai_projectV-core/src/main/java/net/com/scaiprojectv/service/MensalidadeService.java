package net.com.scaiprojectv.service;

import java.util.List;

import javassist.NotFoundException;
import net.com.scaiprojectv.model.Mensalidade;

import com.mysema.query.types.Predicate;

public interface MensalidadeService {

	List<Mensalidade> buscarTodos() throws NotFoundException;

	List<Mensalidade> buscarTodos(Predicate condicao) throws NotFoundException;

	List<Mensalidade> salvarMensalidades(List<Mensalidade> mensalidades);

	Mensalidade salvarMensalidade(Mensalidade mensalidade) throws Exception;

	void excluir(Long id) throws NotFoundException;

	Mensalidade buscarRegistro(Long id)
			throws NotFoundException;

	Mensalidade buscarRegistro(Predicate condicao) throws NotFoundException;
}
