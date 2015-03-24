package mx.hcp.forms;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import mx.hcp.entities.Usuario;

import org.hibernate.validator.constraints.NotEmpty;

public class UsuarioForm {
	@NotNull
	@Min(0)
	private long id = 0;
	@NotEmpty
	private String usuario;
	@NotEmpty
	private String clave;
	@NotEmpty
	private String firma;
	@NotNull
	@Min(1)
	private int diasSiguienteVisita = 1;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getFirma() {
		return firma;
	}
	public void setFirma(String firma) {
		this.firma = firma;
	}
	public int getDiasSiguienteVisita() {
		return diasSiguienteVisita;
	}
	public void setDiasSiguienteVisita(int diasSiguienteVisita) {
		this.diasSiguienteVisita = diasSiguienteVisita;
	}
	
	public UsuarioForm(Usuario u) {
		this.setId(u.getId());
		this.setUsuario(u.getUsuario());
		this.setClave(u.getClave());
		this.setDiasSiguienteVisita(u.getDiasSiguienteCita());
		this.setFirma(u.getFirma());
	}
	public UsuarioForm() {}
}
