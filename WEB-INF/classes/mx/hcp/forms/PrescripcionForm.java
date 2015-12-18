package mx.hcp.forms;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import mx.hcp.entities.Prescripcion;
import mx.mauricioabisay.validation.Trim;

public class PrescripcionForm {
	@NotNull
	@Min(0)
	private long id = 0;
	@Trim
	private String indicaciones;
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
	private int glucosa;
	@NotNull
	private double peso;
	@NotNull
	private double estatura;
	@Trim
	private String dosis1;
	@Trim
	private String dosis2;
	@Trim
	private String dosis3;
	@Trim
	private String medicamentos;
	
	private long paciente;
	private String fechaString;
	private String siguienteCita;
	private boolean exploracionFisica;
	private boolean padecimiento;
	private int plantilla;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIndicaciones() {
		return indicaciones;
	}

	public void setIndicaciones(String indicaciones) {
		this.indicaciones = indicaciones;
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

	public int getGlucosa() {
		return glucosa;
	}

	public void setGlucosa(int glucosa) {
		this.glucosa = glucosa;
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

	public String getMedicamentos() {
		return medicamentos;
	}

	public void setMedicamentos(String medicamentos) {
		this.medicamentos = medicamentos;
	}

	public long getPaciente() {
		return paciente;
	}

	public void setPaciente(long paciente) {
		this.paciente = paciente;
	}

	public String getFechaString() {
		return fechaString;
	}

	public void setFechaString(String fechaString) {
		this.fechaString = fechaString;
	}

	public boolean isExploracionFisica() {
		return exploracionFisica;
	}

	public void setExploracionFisica(boolean exploracionFisica) {
		this.exploracionFisica = exploracionFisica;
	}

	public boolean isPadecimiento() {
		return padecimiento;
	}

	public void setPadecimiento(boolean padecimiento) {
		this.padecimiento = padecimiento;
	}
	
	public int getPlantilla() {
		return plantilla;
	}

	public void setPlantilla(int plantilla) {
		this.plantilla = plantilla;
	}

	public String getSiguienteCita() {
		return siguienteCita;
	}

	public void setSiguienteCita(String siguienteCita) {
		this.siguienteCita = siguienteCita;
	}

	public PrescripcionForm() {}
	
	public PrescripcionForm(long paciente) {
		this.paciente = paciente;
	}
	
	public PrescripcionForm(Prescripcion p) {
		this.setExploracionFisica(true);
		this.setPadecimiento(true);
		this.setDosis1(p.getDosis1());
		this.setDosis2(p.getDosis2());
		this.setDosis3(p.getDosis3());
		this.setEstatura(p.getEstatura());
		this.setFrecuenciaCardiaca(p.getFrecuenciaCardiaca());
		this.setFrecuenciaRespiratoria(p.getFrecuenciaRespiratoria());
		this.setGlucosa(p.getGlucosa());
		this.setId(p.getId());
		this.setIndicaciones(p.getIndicaciones());
		this.setMedicamentos(p.getMedicamentos());
		this.setPaciente(p.getPaciente());
		this.setPeso(p.getPeso());
		this.setPresionDiastolica(p.getPresionDiastolica());
		this.setPresionSistolica(p.getPresionSistolica());
		this.setTemperatura(p.getTemperatura());
		LocalDate date = p.getFecha().toLocalDate();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd / MMMM / uuuu", Locale.forLanguageTag("es-MX"));
		this.setFechaString(date.format(formatter).toUpperCase());
		this.setSiguienteCita(p.getSiguienteCita().toLocalDate().format(DateTimeFormatter.ofPattern("dd/LL/uuuu")));
		this.setPlantilla(p.getPlantilla());
	}
}
