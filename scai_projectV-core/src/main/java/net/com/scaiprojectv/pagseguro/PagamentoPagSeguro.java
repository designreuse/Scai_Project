package net.com.scaiprojectv.pagseguro;

import java.math.BigDecimal;

import net.com.scaiprojectv.model.Aluno;
import net.com.scaiprojectv.model.Turma;
import br.com.uol.pagseguro.domain.PaymentRequest;
import br.com.uol.pagseguro.enums.Currency;
import br.com.uol.pagseguro.enums.DocumentType;
import br.com.uol.pagseguro.exception.PagSeguroServiceException;
import br.com.uol.pagseguro.properties.PagSeguroConfig;

public class PagamentoPagSeguro {
	private PaymentRequest paymentRequest = new PaymentRequest();

	private String idPagamento;
	private String descricaoProduto;
	private Integer quantidade;
	private BigDecimal valorProduto;
	private String nomeCliente;
	private String emailCliente;
	private String DDDCliente;
	private String telefoneCliente;
	private String cpfCliente;

	public PagamentoPagSeguro(String idPagamento, String descricaoProduto,
			Integer quantidade, BigDecimal valorProduto) {
		super();
		this.idPagamento = idPagamento;
		this.descricaoProduto = descricaoProduto;
		this.quantidade = quantidade;
		this.valorProduto = valorProduto;
	}

	public PagamentoPagSeguro(Aluno cliente, Turma produto, Integer qnt) {
		this.idPagamento = cliente.getPagamento().getId().toString();
		this.descricaoProduto = produto.getNomeTurma() + " - Scai Idiomas.";
		this.quantidade = qnt;
		this.valorProduto = new BigDecimal(String.format("%.2f",
				produto.getValorCurso()));
		this.nomeCliente = cliente.getNome();
		this.emailCliente = cliente.getEmail();
		this.DDDCliente = cliente.getDdd();
		this.telefoneCliente = cliente.getTelefone();
		this.cpfCliente = cliente.getCpf();
	}

	public String gerarPagamento() throws PagSeguroServiceException {
		String urlPagamento = "";

		try {
			paymentRequest.addItem(this.getIdPagamento(),// identificacao no
															// sistema
					this.getDescricaoProduto(), // descrição do produto
					this.getQuantidade(),// quantidade
					this.getValorProduto(), // valor do produto
					null, // peso do produto em gramas
					null // valor unitario frete
					);

			paymentRequest.setCurrency(Currency.BRL);

			paymentRequest.setSender(this.getNomeCliente(),
					this.getEmailCliente(), this.getDDDCliente(),
					this.getTelefoneCliente(), DocumentType.CPF,
					this.getCpfCliente());

			// URL para onde o comprador será redirecionado (GET) após o fluxo
			// de
			// pagamento
			// paymentRequest.setRedirectURL("http://www.lojamodelo.com.br/thankyou");

			boolean onlyCheckoutCode = false;
			urlPagamento = paymentRequest.register(
					PagSeguroConfig.getAccountCredentials(), onlyCheckoutCode);

		} catch (PagSeguroServiceException e) {
			throw new PagSeguroServiceException("ERROR PAGSEGURO - "
					+ e.getMessage());
		}

		return urlPagamento;

	}

	public String getIdPagamento() {
		return idPagamento;
	}

	public void setIdPagamento(String idPagamento) {
		this.idPagamento = idPagamento;
	}

	public String getDescricaoProduto() {
		return descricaoProduto;
	}

	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getValorProduto() {
		return valorProduto;
	}

	public void setValorProduto(BigDecimal valorProduto) {
		this.valorProduto = valorProduto;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getEmailCliente() {
		return emailCliente;
	}

	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}

	public String getDDDCliente() {
		return DDDCliente;
	}

	public void setDDDCliente(String dDDCliente) {
		DDDCliente = dDDCliente;
	}

	public String getTelefoneCliente() {
		return telefoneCliente;
	}

	public void setTelefoneCliente(String telefoneCliente) {
		this.telefoneCliente = telefoneCliente;
	}

	public String getCpfCliente() {
		return cpfCliente;
	}

	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}

}
