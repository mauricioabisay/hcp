package mx.hcp.forms;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import mx.hcp.entities.HistoriaClinica;

import org.hibernate.validator.constraints.NotEmpty;

public class HistoriaClinicaForm {
	@NotNull
	@Min(0)
	private long id = 0;
	@NotEmpty
	private String historia = 
	"ANTECEDENTES HEREDO FAMILIARES\n\n\n" + 
	"ANTECEDENTES PERSONALES\n\n\n" + 
	"HISTORIA MEDICAMENTOSA\n\n\n" +
	"ALERGIAS A MEDICAMENTOS Y A LOS ALIMENTOS\n\n\n" +
	"REVISION POR SISTEMAS\n\n\n" +
	"- CABEZA\n\n\n" +
	"- OJOS\n\n\n" +
	"- GARGANTA\n\n\n" +
	"- NARIZ Y OIDO\n\n\n" +
	"- SISTEMA RESPIRATORIO\n\n\n" +
	"- SISTEMA CARDIOVASCULAR\n\n\n" +
	"- SISTEMA GASTROINTESTINAL\n\n\n" +
	"- SISTEMA GENITOURINARIO\n\n\n" +
	"- APARATO GENITAL REPRODUCTOR MASCULINO O FEMENINO\n\n\n" +
	"- PIEL\n\n\n" +
	"- MUSCULO ESQUELETICO\n\n\n" +
	"- SISTEMA ENDOCRINO\n\n\n" +
	"- ESFERA MENTAL\n\n\n" +
	"- OPERACIONES\n\n\n" +
	"- CONSTITUCION\n\n\n" +
	"- LABORATORIOS Y GABINETE";
	
	private long paciente;
	
	private String fechaString;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getHistoria() {
		return historia;
	}
	public void setHistoria(String historia) {
		this.historia = historia;
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
	
	public HistoriaClinicaForm() {}
	
	public HistoriaClinicaForm(long paciente) {
		this.paciente = paciente;
	}
	
	public HistoriaClinicaForm(HistoriaClinica h) {
		LocalDate date = h.getFecha().toLocalDate();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd / MMMM / uuuu", Locale.forLanguageTag("es-MX"));
		
		this.setId(h.getId());
		this.setFechaString(date.format(formatter).toUpperCase());
		this.setHistoria(h.getHistoria());
		this.setPaciente(h.getPaciente());
	}
}
