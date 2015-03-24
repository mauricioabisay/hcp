package mx.hcp.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "exploracion_fisica")
public class ExploracionFisica {
	private long id;
	private int presionSistolica;
	private int presionDiastolica;
	private int frecuenciaCardiaca;
	private int frecuenciaRespiratoria;
	private String pesoIdeal;
	private double temperatura;
	private double peso;
	private double estatura;
	private int glucosa;
	private String observaciones;
	private Date fecha;
	private long paciente;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_exploracion_fisica")
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
	@Column(name = "peso_ideal")
	public String getPesoIdeal() {
		return pesoIdeal;
	}
	public void setPesoIdeal(String pesoIdeal) {
		this.pesoIdeal = pesoIdeal;
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
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
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
