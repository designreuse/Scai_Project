package net.com.scaiprojectv.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import javassist.NotFoundException;
import net.com.scaiprojectv.model.Mensalidade;
import net.com.scaiprojectv.repository.MensalidadeRepository;
import net.com.scaiprojectv.service.MensalidadeService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mysema.query.types.Predicate;

@Service
public class MensalidadeServiceImpl implements MensalidadeService {

	@Resource
	private MensalidadeRepository mensalidadeRepository;

	@Transactional(readOnly = true)
	public List<Mensalidade> buscarTodos() throws NotFoundException {
		List<Mensalidade> retornos = mensalidadeRepository.findAll();

		if (retornos.size() == 0)
			throw new NotFoundException(
					"Nenhum registro encontrado na tabela MENSALIDADE");

		return retornos;
	}

	@Transactional(readOnly = true)
	public List<Mensalidade> buscarTodos(Predicate condicao)
			throws NotFoundException {

		List<Mensalidade> retornos = (List<Mensalidade>) mensalidadeRepository
				.findAll(condicao);

		if (retornos.size() == 0)
			throw new NotFoundException(
					"Nenhum registro encontrado na tabela MENSALIDADE com a condição ["
							+ condicao + "]!");

		return retornos;

	}

	@Transactional(rollbackFor = Exception.class)
	public List<Mensalidade> salvarMensalidades(List<Mensalidade> mensalidades) {
		List<Mensalidade> salvas = new ArrayList<Mensalidade>();

		for (Mensalidade mensalidade : mensalidades) {
			Mensalidade retorno = new Mensalidade();
			retorno = mensalidadeRepository.save(mensalidade);
			salvas.add(retorno);
		}
		return salvas;
	}

	@Transactional(rollbackFor = NotFoundException.class)
	public void excluir(Long id) throws NotFoundException {
		Mensalidade retorno = mensalidadeRepository.findOne(id);

		if (retorno == null)
			throw new NotFoundException(
					"Não foi possível localizar mensalidade com o ID [" + id
							+ "] !");

		mensalidadeRepository.delete(retorno);
	}

	@Transactional(readOnly = true)
	public Mensalidade buscarRegistro(Long id)
			throws NotFoundException {
		return mensalidadeRepository.findOne(id);
	}

	@Transactional(readOnly = true)
	public Mensalidade buscarRegistro(Predicate condicao) {
		return mensalidadeRepository.findOne(condicao);
	}

	@Transactional(rollbackFor = Exception.class)
	public Mensalidade salvarMensalidade(Mensalidade mensalidade)
			throws Exception {
		return mensalidadeRepository.save(mensalidade);
	}

}
