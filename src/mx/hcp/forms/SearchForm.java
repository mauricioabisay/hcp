package mx.hcp.forms;

import java.io.Serializable;

import mx.mauricioabisay.validation.Trim;

public class SearchForm implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Trim
	private String nombre;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
