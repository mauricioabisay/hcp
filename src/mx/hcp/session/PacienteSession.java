package mx.hcp.session;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import mx.hcp.entities.Paciente;
import mx.hcp.enums.Sexo;
import mx.hcp.forms.ExploracionFisicaForm;

public class PacienteSession implements Serializable {
	private static final long serialVersionUID = 1L;
	private long id = -1;
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String edad;
	private String sexo;
	private String ultimaVisita;
	private String siguienteVisita;
	
	private ExploracionFisicaForm exploracion;
	
	public PacienteSession() {}
	
	public PacienteSession(Paciente paciente, ExploracionFisicaForm exploracion) {
		this.id = paciente.getId();
		this.nombre = paciente.getNombre();
		this.apellidoPaterno = paciente.getApellidoPaterno();
		this.apellidoMaterno = paciente.getApellidoMaterno();
		this.exploracion = exploracion;
		
		Period period = Period.between(paciente.getFechaNacimiento().toLocalDate(), LocalDate.now());
		this.edad = period.getYears() + " años, " + period.getMonths() + " meses, " + period.getDays() + " días";
		
		this.sexo = (paciente.getSexo().equals(Sexo.Masculino))? "Hombre" : "Mujer";
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd / MMMM / uuuu", Locale.forLanguageTag("es-MX")); 
		
		Date aux;
		
		aux = paciente.getUltimaVisita();
		if(aux != null) {
			this.ultimaVisita = aux.toLocalDate().format(formatter);
		}
		
		aux = paciente.getSiguienteVisita();
		if(aux != null) {
			this.siguienteVisita = aux.toLocalDate().format(formatter);
		}
		
	}
	
	public PacienteSession(long id, String nombre, String apellidoPaterno, String apellidoMaterno, String edad)  {
		this.id = id;
		this.nombre = nombre;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.edad = edad;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getUltimaVisita() {
		return ultimaVisita;
	}

	public void setUltimaVisita(String ultimaVisita) {
		this.ultimaVisita = ultimaVisita;
	}

	public String getSiguienteVisita() {
		return siguienteVisita;
	}

	public void setSiguienteVisita(String siguienteVisita) {
		this.siguienteVisita = siguienteVisita;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public ExploracionFisicaForm getExploracion() {
		return exploracion;
	}

	public void setExploracion(ExploracionFisicaForm exploracion) {
		this.exploracion = exploracion;
	}
	
}
