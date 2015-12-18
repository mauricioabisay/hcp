package mx.hcp.forms;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import mx.hcp.entities.Estudio;
import mx.mauricioabisay.validation.Trim;

public class EstudioForm {
	@NotNull
	@Min(0)
	private long id = 0;
	private String fechaString;
	@Trim
	private String estudio;
	private long paciente;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFechaString() {
		return fechaString;
	}
	public void setFechaString(String fechaString) {
		this.fechaString = fechaString;
	}
	public String getEstudio() {
		return estudio;
	}
	public void setEstudio(String estudio) {
		this.estudio = estudio;
	}
	public long getPaciente() {
		return paciente;
	}
	public void setPaciente(long paciente) {
		this.paciente = paciente;
	}
	
	public EstudioForm() {}
	
	public EstudioForm(long paciente) {
		this.paciente = paciente;
	}
	
	public EstudioForm(Estudio e) {
		this.setEstudio(e.getEstudio());
		this.setId(e.getId());
		this.setPaciente(e.getPaciente());
		LocalDate date = e.getFecha().toLocalDate();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd / MMMM / uuuu", Locale.forLanguageTag("es-MX"));
		this.setFechaString(date.format(formatter).toUpperCase());
	}
}
