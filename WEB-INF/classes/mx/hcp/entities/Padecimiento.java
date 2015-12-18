package mx.hcp.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "padecimiento")
public class Padecimiento {
	private long id;
	private String sintomas;
	private String medicamentos;
	private String dosis1;
	private String dosis2;
	private String dosis3;
	private Date fecha;
	private long paciente;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_padecimiento")
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getSintomas() {
		return sintomas;
	}
	public void setSintomas(String sintomas) {
		this.sintomas = sintomas;
	}
	public String getMedicamentos() {
		return medicamentos;
	}
	public void setMedicamentos(String medicamentos) {
		this.medicamentos = medicamentos;
	}
	public String getDosis1() {
		return dosis1;
	}
	public void setDosis1(String dosis1) {
		this.dosis1 = dosis1;
	}
	public String getDosis2() {
		return dosis2;
	}
	public void setDosis2(String dosis2) {
		this.dosis2 = dosis2;
	}
	public String getDosis3() {
		return dosis3;
	}
	public void setDosis3(String dosis3) {
		this.dosis3 = dosis3;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	@Column(name = "paciente_fk")
	public long getPaciente() {
		return paciente;
	}
	public void setPaciente(long paciente) {
		this.paciente = paciente;
	}
}
