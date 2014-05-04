/**
 * 
 */
package net.com.scaiprojectv.repository.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import net.com.scaiprojectv.config.test.ApplicationContextTest;
import net.com.scaiprojectv.model.Pessoa;
import net.com.scaiprojectv.predicate.PessoaPredicate;
import net.com.scaiprojectv.service.PessoaService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

/**
 * Comment(s): Classe de testes da entidade Pessoa.
 * 
 * @author Paulo Garcia
 * @Feb 20, 2014
 * @5:26:36 PM
 * 
 *          Scai Project_V®
 * 
 *          Developed by Paulo Garcia
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationContextTest.class)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
		DirtiesContextTestExecutionListener.class,
		TransactionalTestExecutionListener.class })
@TransactionConfiguration(defaultRollback = true)
@Transactional
public class PessoaServiceImplTest {

	@Autowired
	private PessoaService alunoService;

	private Pessoa pessoa;

	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public PessoaServiceImplTest() throws ParseException {
//		pessoa = new Pessoa();
//		pessoa.setNome("Paulo");
//		pessoa.setSobreNome("Garcia");
//		pessoa.setDataNascimento(sdf.parse("18/05/1989"));
//		pessoa.setRg("44.839.159-3");
//		pessoa.setSexo('m');
//		pessoa.setTelefone("3462-2016");
//		pessoa.setDdd("17");
//		pessoa.setCpf("394.714.358-38");
	}

	@Test
	public void deveVerificarSeEstaCadastrando() throws ParseException {
		Pessoa retorno = alunoService.criar(pessoa);
		Assert.assertNotNull(retorno);
		alunoService.remover(retorno.getId());
	}

	@Test
	public void deveVerificarSeEstaListandoTodosAsPessoas()
			throws ParseException {
		List<Pessoa> pessoas = cadastrarPessoas();
		List<Pessoa> retorno = alunoService.buscarTodos();

		Assert.assertEquals(pessoas.size(), retorno.size());
		deveExcluirTodosValores(retorno);
	}

	@Test
	public void deveVeridicarSeNaoEstaCadastrandoComCampoObrigatorioNull() {

	}

	@Test
	public void deveVerificarSeEstaRemovendoPessoa() throws ParseException {
		deveExcluirTodosValores(cadastrarPessoas());
		List<Pessoa> retorno = alunoService.buscarTodos();
		Assert.assertEquals(0, retorno.size());
	}

	@Test
	public void deveVerificarSeEstaRemovendoPessoaPorId() {
		alunoService.criar(pessoa);
		List<Pessoa> retorno = alunoService.buscarTodos();
		Pessoa pessoa = alunoService.buscarPorId(retorno.get(0).getId());
		Assert.assertEquals(this.pessoa.getNome(), pessoa.getNome());
		alunoService.remover(pessoa.getId());
	}

	@Test
	public void deveVerificarSeEstaAlterandoORegistroDePessoa() {
		Pessoa retorno1 = alunoService.criar(this.pessoa);
		Assert.assertEquals(retorno1.getNome(), pessoa.getNome());

		pessoa.setNome("Nome Alterado");
		Pessoa retorno2 = alunoService.criar(pessoa);

		Assert.assertEquals(this.pessoa.getNome(), retorno2.getNome());
	}

	private void deveExcluirTodosValores(List<Pessoa> pessoas) {

		for (Pessoa pessoa : pessoas) {
			alunoService.remover(pessoa.getId());
		}

	}

	private List<Pessoa> cadastrarPessoas() throws ParseException {
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
//
//		Pessoa pessoa1 = new Pessoa();
//		pessoa1.setNome("Camila Garcia");
//		pessoa1.setSobrenome("Cristina");
//		pessoa1.setDataNascimento(sdf.parse("10/08/1987"));
//		pessoa1.setRg("849.840.163.3");
//		pessoa1.setCpf("849.579.100-23");
//		pessoa1.setDdd("12");
//		pessoa1.setTelefone("3958-2949");
//		pessoa1.setSexo('F');
//		pessoas.add(pessoa1);
//
//		Pessoa pessoa2 = new Pessoa();
//		pessoa2.setNome("Renato");
//		pessoa2.setSobrenome("Silva");
//		pessoa2.setDataNascimento(sdf.parse("14/01/1999"));
//		pessoa2.setRg("849.840.163.3");
//		pessoa2.setCpf("849.579.100-23");
//		pessoa2.setDdd("12");
//		pessoa2.setTelefone("9302-9372");
//		pessoa2.setSexo('M');
//		pessoas.add(pessoa2);
//
//		Pessoa pessoa3 = new Pessoa();
//		pessoa3.setNome("Ranam");
//		pessoa3.setSobrenome("Moureira");
//		pessoa3.setDataNascimento(sdf.parse("14/12/2001"));
//		pessoa3.setRg("849.840.163.3");
//		pessoa3.setCpf("849.579.100-23");
//		pessoa3.setDdd("12");
//		pessoa3.setTelefone("3958-2949");
//		pessoa3.setSexo('f');
//		pessoas.add(pessoa3);
//
//		alunoService.criar(pessoa1);
//		alunoService.criar(pessoa2);
//		alunoService.criar(pessoa3);

		return pessoas;
	}

}
