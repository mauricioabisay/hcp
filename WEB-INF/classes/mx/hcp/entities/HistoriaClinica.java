package mx.hcp.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "historia_clinica")
public class HistoriaClinica {
	private long id;
	private Date fecha;
	private String historia;
	private long paciente;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_historia_clinica")
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getHistoria() {
		return historia;
	}
	public void setHistoria(String historia) {
		this.historia = historia;
	}
	@Column(name = "paciente_fk")
	public long getPaciente() {
		return paciente;
	}
	public void setPaciente(long paciente) {
		this.paciente = paciente;
	}
}
