package net.com.scaiprojectv.dto;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import net.com.scaiprojectv.enumerator.StatusPagamento;
import net.com.scaiprojectv.model.Mensalidade;
import net.com.scaiprojectv.model.Pagamento;

public class GerarMensalidadesDTO {

	private Calendar dataAtual = Calendar.getInstance();
	private Integer qntParcelas;
	private Integer diaVencimento;
	private Double valorTotal;
	private Long idPagamento;

	public GerarMensalidadesDTO(Integer qntParcelas, Integer diaVencimento,
			Double valorTotal, Long idPagamento) {
		super();
		this.qntParcelas = qntParcelas;
		this.diaVencimento = diaVencimento;
		this.valorTotal = valorTotal;
		this.idPagamento = idPagamento;
	}

	public List<Mensalidade> gerarParcelas() {
		List<Mensalidade> mensalidades = new ArrayList<Mensalidade>();
		Double valorMensalidade = this.getValorTotal() / this.getQntParcelas();
		Pagamento pagamento = new Pagamento();
		pagamento.setId(this.getIdPagamento());

		for (int i = 0; i < this.getQntParcelas(); i++) {
			Mensalidade mensalidade = new Mensalidade();

			// define data de vencimento
			dataAtual.set(Calendar.DAY_OF_MONTH, diaVencimento);
			dataAtual.add(Calendar.MONTH, 1);
			mensalidade.setDataVencimento(dataAtual.getTime());

			mensalidade.setValorPago(valorMensalidade);
			mensalidade.setStatusPagamento(StatusPagamento.EM_ABERTO);
			mensalidade.setPagamento(pagamento);

			mensalidades.add(mensalidade);
		}

		return mensalidades;
	}

	public Long getIdPagamento() {
		return idPagamento;
	}

	public void setIdPagamento(Long idPagamento) {
		this.idPagamento = idPagamento;
	}

	public Calendar getDataAtual() {
		return dataAtual;
	}

	public void setDataAtual(Calendar dataAtual) {
		this.dataAtual = dataAtual;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Integer getDiaVencimento() {
		return diaVencimento;
	}

	public void setDiaVencimento(Integer diaVencimento) {
		this.diaVencimento = diaVencimento;
	}

	public Integer getQntParcelas() {
		return qntParcelas;
	}

	public void setQntParcelas(Integer qntParcelas) {
		this.qntParcelas = qntParcelas;
	}

}
