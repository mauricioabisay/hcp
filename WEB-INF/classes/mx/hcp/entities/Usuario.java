package mx.hcp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {
	
	private long id;
	private String usuario;
	private String clave;
	private String firma;
	private int diasSiguienteCita;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
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
	@Column(name = "dias_siguiente_visita")
	public int getDiasSiguienteCita() {
		return diasSiguienteCita;
	}
	public void setDiasSiguienteCita(int diasSiguienteCita) {
		this.diasSiguienteCita = diasSiguienteCita;
	}
}
