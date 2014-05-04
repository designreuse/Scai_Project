package net.com.scaiprojectv.repository.test;

import java.util.Date;
import java.util.List;

import junit.framework.Assert;
import net.com.scaiprojectv.config.test.ApplicationContextTest;
import net.com.scaiprojectv.enumerator.AcessoSistemaEnum;
import net.com.scaiprojectv.model.Cidade;
import net.com.scaiprojectv.model.Funcionario;
import net.com.scaiprojectv.model.Materia;
import net.com.scaiprojectv.service.FuncionarioService;
import net.com.scaiprojectv.service.MateriaService;

import org.junit.Before;
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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationContextTest.class)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
		DirtiesContextTestExecutionListener.class,
		TransactionalTestExecutionListener.class })
@TransactionConfiguration(defaultRollback = true)
@Transactional
public class FuncionarioRepositoryTest {

	@Autowired
	private FuncionarioService funcionarioService;
	
	@Autowired
	private MateriaService materiaService;
	
	private Funcionario funcionario;
	private Cidade cidade;
	private Materia materia;
	
	public FuncionarioRepositoryTest(){
		funcionario = new Funcionario();
		funcionario.setNome("Paulo");
		funcionario.setSobrenome("Garcia");
		funcionario.setAcessoSistema(AcessoSistemaEnum.ADMINISTRADOR);
		funcionario.setCargo("Analista");
		funcionario.setCpf("395.716.358-78");
		funcionario.setRg("358.948.049-9");
		funcionario.setDataAdmissao(new Date());
		funcionario.setDataNascimento(new Date());
		funcionario.setDdd("17");
		funcionario.setTelefone("84939-9482");
		funcionario.setEmail("gpaulo42@gmail.com");
		funcionario.setDiaVencimentoSalario(Short.parseShort("10"));
		funcionario.setLogin("pGarcia");
		funcionario.setSenha("123456");
		funcionario.setSalario(1.000);
		
		cidade = new Cidade();
		cidade.setCep("15600.000");
		cidade.setEstado("São Paulo");
		cidade.setNome("Fernandópolis");
		funcionario.setCidade(cidade);
	}
	
	@Before
	@Test
	public void deveTestarCadastrarMateria(){
		materia = new Materia();
		materia.setNome("Ingles");
		materia.setStatus(true);
		Assert.assertNotNull(materiaService.salvar(materia));
	}
	
	@Test
	public void deveTestarCadastrarUmFuncionario(){
		List<Materia> materiaRetorno = materiaService.buscarTodos();
		Assert.assertNotNull(funcionarioService.salvar(funcionario));
	}
	
}
