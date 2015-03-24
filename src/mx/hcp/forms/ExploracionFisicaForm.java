package mx.hcp.forms;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import mx.hcp.entities.ExploracionFisica;
import mx.mauricioabisay.validation.Trim;

public class ExploracionFisicaForm {
	@NotNull
	@Min(0)
	private long id = 0;
	@Trim
	@Pattern(regexp = "\\d{1,3}/\\d{1,3}")
	private String presion;
	@NotNull
	private int presionSistolica;
	@NotNull
	private int presionDiastolica;
	@NotNull
	private int frecuenciaCardiaca;
	@NotNull
	private int frecuenciaRespiratoria;
	@NotNull
	private double temperatura;
	@NotNull
	private double peso;
	@NotNull
	private double estatura;
	@NotNull
	private int glucosa;
	@Trim
	private String observaciones;
	
	private String fechaString;
	private long paciente;
	private String pesoIdeal;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getPresion() {
		return presion;
	}

	public void setPresion(String presion) {
		this.presion = presion;
	}

	public int getPresionSistolica() {
		return presionSistolica;
	}

	public void setPresionSistolica(int presionSistolica) {
		this.presionSistolica = presionSistolica;
	}

	public int getPresionDiastolica() {
		return presionDiastolica;
	}

	public void setPresionDiastolica(int presionDiastolica) {
		this.presionDiastolica = presionDiastolica;
	}

	public int getFrecuenciaCardiaca() {
		return frecuenciaCardiaca;
	}

	public void setFrecuenciaCardiaca(int frecuenciaCardiaca) {
		this.frecuenciaCardiaca = frecuenciaCardiaca;
	}

	public int getFrecuenciaRespiratoria() {
		return frecuenciaRespiratoria;
	}

	public void setFrecuenciaRespiratoria(int frecuenciaRespiratoria) {
		this.frecuenciaRespiratoria = frecuenciaRespiratoria;
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

	public String getFechaString() {
		return fechaString;
	}

	public void setFechaString(String fechaString) {
		this.fechaString = fechaString;
	}

	public long getPaciente() {
		return paciente;
	}

	public void setPaciente(long paciente) {
		this.paciente = paciente;
	}

	public String getPesoIdeal() {
		return pesoIdeal;
	}

	public void setPesoIdeal(String pesoIdeal) {
		this.pesoIdeal = pesoIdeal;
	}

	public ExploracionFisicaForm() {}
	
	public ExploracionFisicaForm(long paciente) {
		this.setPaciente(paciente);
	}
	
	public ExploracionFisicaForm(ExploracionFisica f) {
		this.setId(f.getId());
		this.setEstatura(f.getEstatura());
		this.setFrecuenciaCardiaca(f.getFrecuenciaCardiaca());
		this.setFrecuenciaRespiratoria(f.getFrecuenciaRespiratoria());
		this.setGlucosa(f.getGlucosa());
		this.setObservaciones(f.getObservaciones());
		this.setPaciente(f.getPaciente());
		this.setPeso(f.getPeso());
		this.setPesoIdeal(f.getPesoIdeal());
		this.setPresion(f.getPresionSistolica() + "/" + f.getPresionDiastolica());
		this.setPresionDiastolica(f.getPresionDiastolica());
		this.setPresionSistolica(f.getPresionSistolica());
		this.setTemperatura(f.getTemperatura());
		LocalDate date = f.getFecha().toLocalDate();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd / MMMM / uuuu", Locale.forLanguageTag("es-MX"));
		this.setFechaString(date.format(formatter).toUpperCase());
	}
}
