package net.com.scaiprojectv.dto;

import java.util.ArrayList;
import java.util.List;

public class EstadosBrasileiroDTO {

	private static List<String> getEstados = new ArrayList<String>();
	
	public static List<String> getEstadosbrasileiro(){
		getEstados.add("São Paulo");
		getEstados.add("Acre");
		getEstados.add("Alagoas");
		getEstados.add("Amapá");
		getEstados.add("Amazonas");
		getEstados.add("Bahia");
		getEstados.add("Ceará");
		getEstados.add("Distrito Federal");
		getEstados.add("Espírito Santo");
		getEstados.add("Goiás");
		getEstados.add("Maranhão");
		getEstados.add("Mato Grosso");
		getEstados.add("Mato Grosso do Sul");
		getEstados.add("Minas Gerais");
		getEstados.add("Pará");
		getEstados.add("Paraíba");
		getEstados.add("Paraná");
		getEstados.add("Pernambuco");
		getEstados.add("Piauí");
		getEstados.add("Rio de Janeiro");
		getEstados.add("Rio Grande do Norte");
		getEstados.add("Rio Grande do Sul");
		getEstados.add("Rondônia");
		getEstados.add("Roraima");
		getEstados.add("Santa Catarina");
		getEstados.add("Sergipe");
		getEstados.add("Tocantins");
		
		return getEstados;
	}
	
}
