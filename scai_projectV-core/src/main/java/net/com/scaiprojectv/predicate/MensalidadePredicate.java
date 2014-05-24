package net.com.scaiprojectv.predicate;

import net.com.scaiprojectv.model.QMensalidade;

import com.mysema.query.types.Predicate;

public class MensalidadePredicate {

	public static Predicate buscarMensalidadesPorPagamento(Long idPagamento) {
		QMensalidade condicao = QMensalidade.mensalidade;
		return condicao.pagamento.id.eq(idPagamento);
	}

}
