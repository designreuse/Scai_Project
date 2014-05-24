package teste;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import net.com.scaiprojectv.enumerator.TipoPagamentoEnum;
import net.com.scaiprojectv.model.Aluno;
import net.com.scaiprojectv.model.Pagamento;
import net.com.scaiprojectv.service.AlunoService;
import net.com.scaiprojectv.service.impl.AlunoServiceImpl;

public class ClasseDeTestes {

	
	public static void main(String[] args) throws Exception {
		AlunoService alunoService = new AlunoServiceImpl();
		
		Pagamento pagamento = new Pagamento();
		pagamento.setTipoPagamento(TipoPagamentoEnum.A_VISTA);
		
		Aluno aluno = new Aluno();
		aluno.setNome("Paulo");
		aluno.setRg("44.830.150-3");
		aluno.setDataNascimento(new Date());
		aluno.setEmail("gpaulo42@gmail.com");
		aluno.setDdd("17");
		aluno.setTelefone("9 9626 8985");
		aluno.setSexo("M");
		aluno.setPagamento(pagamento);
		
		for(int i = 0 ; i < 100; i++){
			aluno.setCpf("123.123." + i);
			alunoService.salvar(aluno);
		}
		
	}
	
}
