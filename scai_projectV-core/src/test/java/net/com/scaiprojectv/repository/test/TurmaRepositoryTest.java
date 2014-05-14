package net.com.scaiprojectv.repository.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import junit.framework.Assert;
import net.com.scaiprojectv.config.test.ApplicationContextTest;
import net.com.scaiprojectv.model.HorarioDiaAula;
import net.com.scaiprojectv.model.Turma;
import net.com.scaiprojectv.service.TurmaService;

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
public class TurmaRepositoryTest {

	private Turma turma;
	private List<HorarioDiaAula> horarios = new ArrayList<HorarioDiaAula>();
	private HorarioDiaAula horario;
	
	@Autowired
	private TurmaService turmaService;
	
	public TurmaRepositoryTest() {
		turma = new Turma();
		horario = new HorarioDiaAula();
		
		turma.setNomeTurma("Nome da turma");
		turma.setPrevisaoInicio(new Date());
		turma.setPrevisaoTermino(new Date());
		turma.setVagasDisponiveis(10);
		
		horario.setDiaSemana("segunda-feira");
		horario.setHorarioInicio("15h00");
		horario.setHorarioTermino("17h00m");
		horarios.add(horario);
		
		turma.setHorariosAulas(horarios);
	}
	
	@Test
	public void deveCadastrarTurma(){
		Turma retorno = turmaService.cadastrar(turma);
		Assert.assertNotNull(retorno);
		Turma retornoRegistro = turmaService.buscarRegistro(retorno.getId());
		Assert.assertNotNull(retornoRegistro);
		System.out.println("retorno: " + retornoRegistro.getHorariosAulas().get(0).getDiaSemana());
	}
}