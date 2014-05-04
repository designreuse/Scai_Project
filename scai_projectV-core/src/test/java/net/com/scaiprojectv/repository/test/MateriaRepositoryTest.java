package net.com.scaiprojectv.repository.test;

import junit.framework.Assert;
import net.com.scaiprojectv.config.test.ApplicationContextTest;
import net.com.scaiprojectv.enumerator.TipoAlunoEnum;
import net.com.scaiprojectv.model.Materia;
import net.com.scaiprojectv.service.MateriaService;

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
public class MateriaRepositoryTest {

	@Autowired
	private MateriaService materiaService;
	
	@Test
	public void deveTestarCadastrarUmaMateriaComCamposNulo(){
		Materia materia = new Materia();
		materia.setNome("Nome teste");
		Assert.assertNotNull(materiaService.salvar(materia));
	}
	
}
