/**
 * 
 */
package net.com.scaiprojectv.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import net.com.scaiprojectv.enumerator.TipoPagamentoEnum;

/**
 * Comment(s): 
 * 
 * @author Paulo Garcia
 * @Feb 26, 2014
 * @5:24:08 PM
 *
 * Scai Project_V®
 *
 * Developed by Paulo Garcia
 */
@Entity
public class Pagamento {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private TipoPagamentoEnum tipoPagamento;
	
	private Integer quantidadeParcela;
	
	private Long diaVencimento;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoPagamentoEnum getTipoPagamento() {
		return tipoPagamento;
	}

	public void setTipoPagamento(TipoPagamentoEnum tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}

	public Integer getQuantidadeParcela() {
		return quantidadeParcela;
	}

	public void setQuantidadeParcela(Integer quantidadeParcela) {
		this.quantidadeParcela = quantidadeParcela;
	}

	public Long getDiaVencimento() {
		return diaVencimento;
	}

	public void setDiaVencimento(Long diaVencimento) {
		this.diaVencimento = diaVencimento;
	}
	
	
	
}
