package net.com.scaiprojectv.editor;

import net.com.scaiprojectv.model.Matricula;
import net.com.scaiprojectv.service.MatriculaService;

import org.springframework.beans.propertyeditors.PropertiesEditor;

public class CustomMateriaEditor extends PropertiesEditor {

	private MatriculaService matriculaService;

	public CustomMateriaEditor(MatriculaService matriculaService) {
		this.matriculaService = matriculaService;
	}

	public void setAsText(String text) throws IllegalArgumentException {
		Long id = new Long(text);
		Matricula matricula = new Matricula();
		try {
			matricula = this.matriculaService.buscarRegistro(id);
		} catch (Exception e) {
			setValue(matricula);
		}
		setValue(matricula);
	}

}
