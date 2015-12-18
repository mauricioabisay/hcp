package mx.hcp.forms;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import mx.hcp.entities.Paciente;
import mx.hcp.enums.EstadoCivil;
import mx.hcp.enums.Sexo;
import mx.mauricioabisay.validation.Trim;

import org.hibernate.validator.constraints.NotEmpty;

public class PacienteForm {
	@NotNull
	@Min(0)
	private long id = 0;
	@NotEmpty
	private String nombre;
	@NotEmpty
	private String apellidoPaterno;
	@NotEmpty
	private String apellidoMaterno;
	
	@NotNull
	@Min(1)
	@Max(31)
	private int day;
	@NotNull
	@Min(1)
	@Max(12)
	private int month;
	@NotNull
	private int year;
	
	@NotEmpty
	private String calleynum;
	@NotEmpty
	private String colonia;
	@Trim
	private String cp;
	@NotEmpty
	private String pais;
	@Trim
	private String otroPais;
	@NotEmpty
	private String estado;
	@Trim
	private String otroEstado;
	@NotEmpty
	private String ciudad;
	@Trim
	private String telefono;
	@NotNull
	private EstadoCivil estadoCivil;
	@Trim
	private String ocupacion;
	@NotNull
	private Sexo sexo;
	@Trim
	private String rfc;
	@Trim
	private String recomendado;
	@Trim
	private String observaciones;
	
	private Date ultimaVisita;
	private Date siguienteVisita;
	
	private String fechaNacimientoString;
	private String ultimaVisitaString;
	private String siguienteVisitaString;
	private String edadString;
	
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
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getCalleynum() {
		return calleynum;
	}
	public void setCalleynum(String calleynum) {
		this.calleynum = calleynum;
	}
	public String getColonia() {
		return colonia;
	}
	public void setColonia(String colonia) {
		this.colonia = colonia;
	}
	public String getCp() {
		return cp;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getOtroPais() {
		return otroPais;
	}
	public void setOtroPais(String otroPais) {
		this.otroPais = otroPais;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getOtroEstado() {
		return otroEstado;
	}
	public void setOtroEstado(String otroEstado) {
		this.otroEstado = otroEstado;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	public String getOcupacion() {
		return ocupacion;
	}
	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}
	public Sexo getSexo() {
		return sexo;
	}
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
	public String getRfc() {
		return rfc;
	}
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}
	public String getRecomendado() {
		return recomendado;
	}
	public void setRecomendado(String recomendado) {
		this.recomendado = recomendado;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public Date getUltimaVisita() {
		return ultimaVisita;
	}
	public void setUltimaVisita(Date ultimaVisita) {
		this.ultimaVisita = ultimaVisita;
	}
	public Date getSiguienteVisita() {
		return siguienteVisita;
	}
	public void setSiguienteVisita(Date siguienteVisita) {
		this.siguienteVisita = siguienteVisita;
	}
	public String getFechaNacimientoString() {
		return fechaNacimientoString;
	}
	public void setFechaNacimientoString(String fechaNacimientoString) {
		this.fechaNacimientoString = fechaNacimientoString;
	}
	public String getUltimaVisitaString() {
		return ultimaVisitaString;
	}
	public void setUltimaVisitaString(String ultimaVisitaString) {
		this.ultimaVisitaString = ultimaVisitaString;
	}
	public String getSiguienteVisitaString() {
		return siguienteVisitaString;
	}
	public void setSiguienteVisitaString(String siguienteVisitaString) {
		this.siguienteVisitaString = siguienteVisitaString;
	}
	public String getEdadString() {
		return edadString;
	}
	public void setEdadString(String edadString) {
		this.edadString = edadString;
	}
	
	public PacienteForm() {}
	public PacienteForm(Paciente p) {
		this.setApellidoMaterno(p.getApellidoMaterno());
		this.setApellidoPaterno(p.getApellidoPaterno());
		this.setCalleynum(p.getCalleynum());
		this.setCiudad(p.getCiudad());
		this.setColonia(p.getColonia());
		this.setCp(p.getCp());
		LocalDate date = p.getFechaNacimiento().toLocalDate();
		this.setDay(date.getDayOfMonth());
		this.setEstado(p.getEstado());
		this.setEstadoCivil(p.getEstadoCivil());
		this.setId(p.getId());
		this.setMonth(date.getMonthValue());
		this.setNombre(p.getNombre());
		this.setOcupacion(p.getOcupacion());
		this.setPais(p.getPais());
		this.setRecomendado(p.getRecomendado());
		this.setRfc(p.getRfc());
		this.setSexo(p.getSexo());
		this.setSiguienteVisita(p.getSiguienteVisita());
		this.setTelefono(p.getTelefono());
		this.setUltimaVisita(p.getUltimaVisita());
		this.setYear(date.getYear());
		this.setObservaciones(p.getObservaciones());
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd / MMMM / uuuu", Locale.forLanguageTag("es-MX"));
		Period period = Period.between(date, LocalDate.now());
		this.setEdadString(period.getYears() + " años, " + period.getMonths() + " meses, " + period.getDays() + " días");
		
		this.setFechaNacimientoString(date.format(formatter).toUpperCase());
		
		Date aux;
		aux = p.getUltimaVisita();
		if(aux != null) {
			this.setUltimaVisitaString(aux.toLocalDate().format(formatter).toUpperCase());
		}
		aux = p.getSiguienteVisita();
		if(aux != null) {
			this.setSiguienteVisitaString(aux.toLocalDate().format(formatter).toUpperCase());
		}
		
		
		
	}
}
