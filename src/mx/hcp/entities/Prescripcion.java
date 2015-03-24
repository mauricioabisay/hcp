package mx.hcp.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "prescripcion")
public class Prescripcion {
	private long id;
	private int presionSistolica;
	private int presionDiastolica;
	private int frecuenciaCardiaca;
	private int frecuenciaRespiratoria;
	private long paciente;
	private String indicaciones;
	private String indicacionesAdicionales;
	private double temperatura;
	private double peso;
	private double estatura;
	private int glucosa;
	private String medicamentos;
	private String dosis1;
	private String dosis2;
	private String dosis3;
	private Date fecha;
	private Date siguienteCita;
	private int plantilla;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_prescripcion")
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	@Column(name = "presion_sistolica")
	public int getPresionSistolica() {
		return presionSistolica;
	}
	public void setPresionSistolica(int presionSistolica) {
		this.presionSistolica = presionSistolica;
	}
	@Column(name = "presion_diastolica")
	public int getPresionDiastolica() {
		return presionDiastolica;
	}
	public void setPresionDiastolica(int presionDiastolica) {
		this.presionDiastolica = presionDiastolica;
	}
	@Column(name = "frec_cardiaca")
	public int getFrecuenciaCardiaca() {
		return frecuenciaCardiaca;
	}
	public void setFrecuenciaCardiaca(int frecuenciaCardiaca) {
		this.frecuenciaCardiaca = frecuenciaCardiaca;
	}
	@Column(name = "frec_respiratoria")
	public int getFrecuenciaRespiratoria() {
		return frecuenciaRespiratoria;
	}
	public void setFrecuenciaRespiratoria(int frecuenciaRespiratoria) {
		this.frecuenciaRespiratoria = frecuenciaRespiratoria;
	}
	@Column(name = "paciente_fk")
	public long getPaciente() {
		return paciente;
	}
	public void setPaciente(long paciente) {
		this.paciente = paciente;
	}
	public String getIndicaciones() {
		return indicaciones;
	}
	public void setIndicaciones(String indicaciones) {
		this.indicaciones = indicaciones;
	}
	@Column(name = "indicaciones_adicionales")
	public String getIndicacionesAdicionales() {
		return indicacionesAdicionales;
	}
	public void setIndicacionesAdicionales(String indicacionesAdicionales) {
		this.indicacionesAdicionales = indicacionesAdicionales;
	}
	public double getTemperatura() {
		return temperatura;
	}
	public void setTemperatura(double temperatura) {
		this.temperatura = temperatura;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public double getEstatura() {
		return estatura;
	}
	public void setEstatura(double estatura) {
		this.estatura = estatura;
	}
	public int getGlucosa() {
		return glucosa;
	}
	public void setGlucosa(int glucosa) {
		this.glucosa = glucosa;
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
	@Column(name = "fecha_siguiente_cita")
	public Date getSiguienteCita() {
		return siguienteCita;
	}
	public void setSiguienteCita(Date siguienteCita) {
		this.siguienteCita = siguienteCita;
	}
	public int getPlantilla() {
		return plantilla;
	}
	public void setPlantilla(int plantilla) {
		this.plantilla = plantilla;
	}
}
