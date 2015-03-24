package mx.hcp.session;

import java.io.Serializable;

import mx.hcp.entities.Usuario;

public class UsuarioSession implements Serializable {
	private static final long serialVersionUID = 1L;
	private long idUsuario;
	private String user;
	private String current;
	private String firma;
	private int diasSiguienteCita;
	
	public UsuarioSession() {}
	
	public UsuarioSession(Usuario usuario) {
		this.idUsuario = usuario.getId();
		this.user = usuario.getUsuario();
		this.firma = usuario.getFirma();
		this.diasSiguienteCita = usuario.getDiasSiguienteCita();
	}
	
	public long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getCurrent() {
		return current;
	}
	public void setCurrent(String current) {
		this.current = current;
	}
	public String getFirma() {
		return firma;
	}
	public void setFirma(String firma) {
		this.firma = firma;
	}
	public int getDiasSiguienteCita() {
		return diasSiguienteCita;
	}
	public void setDiasSiguienteCita(int diasSiguienteCita) {
		this.diasSiguienteCita = diasSiguienteCita;
	}
}
