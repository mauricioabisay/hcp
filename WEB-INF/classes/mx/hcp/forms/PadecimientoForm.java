package mx.hcp.forms;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import mx.hcp.entities.Padecimiento;
import mx.mauricioabisay.validation.Trim;

import org.hibernate.validator.constraints.NotEmpty;

public class PadecimientoForm {
	@NotNull
	@Min(0)
	private long id  = 0;
	@NotEmpty
	private String sintomas = 
	"SINTOMAS\n\n\n\n\n\n\n\n\n\n" 
	+ "DOSIS\n\n\nMEDICAMENTOS";
	@Trim
	private String medicamentos;
	@Trim
	private String dosis1;
	@Trim
	private String dosis2;
	@Trim
	private String dosis3;
	
	private String fechaString;
	private long paciente;
	
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
	
	public PadecimientoForm() {}
	
	public PadecimientoForm(long paciente) {
		this.paciente = paciente;
	}
	
	public PadecimientoForm(Padecimiento p) {
		this.setId(p.getId());
		
		this.setDosis1(p.getDosis1());
		this.setDosis2(p.getDosis2());
		this.setDosis3(p.getDosis3());
		this.setMedicamentos(p.getMedicamentos());
		this.setPaciente(p.getPaciente());
		this.setSintomas(p.getSintomas());
		LocalDate date = p.getFecha().toLocalDate();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd / MMMM / uuuu", Locale.forLanguageTag("es-MX"));
		this.setFechaString(date.format(formatter).toUpperCase());
	}
}
