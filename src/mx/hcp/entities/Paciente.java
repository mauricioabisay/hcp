package mx.hcp.entities;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import mx.hcp.enums.EstadoCivil;
import mx.hcp.enums.Sexo;
import mx.hcp.forms.PacienteForm;

@Entity
@Table(name = "pacientes")
public class Paciente {
	private long id;
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private Date fechaNacimiento;
	private String calleynum;
	private String colonia;
	private String cp;
	private String pais;
	private String estado;
	private String ciudad;
	private String telefono;
	private String edocivil;
	private EstadoCivil estadoCivil;
	private String ocupacion;
	private String fecnac;
	private String edad;
	private Sexo sexo;
	private String ultvisita;
	private String rfc;
	private String historiacli = "";
	private String estudios;
	private String observaciones;
	private String recomendado;
	private Date ultimaVisita;
	private Date siguienteVisita;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idpaciente")
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
	
	@Column(name = "apellido_paterno")
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}
	
	@Column(name = "apellido_materno")
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}
	
	@Column(name = "fecha_nacimiento")
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
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
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
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
	public String getEdocivil() {
		return edocivil;
	}
	public void setEdocivil(String edocivil) {
		this.edocivil = edocivil;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "estado_civil")
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
	public String getFecnac() {
		return fecnac;
	}
	public void setFecnac(String fecnac) {
		this.fecnac = fecnac;
	}
	public String getEdad() {
		return edad;
	}
	public void setEdad(String edad) {
		this.edad = edad;
	}
	@Enumerated(EnumType.STRING)
	public Sexo getSexo() {
		return sexo;
	}
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
	public String getUltvisita() {
		return ultvisita;
	}
	public void setUltvisita(String ultvisita) {
		this.ultvisita = ultvisita;
	}
	public String getRfc() {
		return rfc;
	}
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}
	public String getHistoriacli() {
		return historiacli;
	}
	public void setHistoriacli(String historiacli) {
		this.historiacli = historiacli;
	}
	public String getEstudios() {
		return estudios;
	}
	public void setEstudios(String estudios) {
		this.estudios = estudios;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public String getRecomendado() {
		return recomendado;
	}
	public void setRecomendado(String recomendado) {
		this.recomendado = recomendado;
	}
	
	@Column(name = "ultima_visita")
	public Date getUltimaVisita() {
		return ultimaVisita;
	}
	public void setUltimaVisita(Date ultimaVisita) {
		this.ultimaVisita = ultimaVisita;
	}
	
	@Column(name = "siguiente_visita")
	public Date getSiguienteVisita() {
		return siguienteVisita;
	}
	public void setSiguienteVisita(Date siguienteVisita) {
		this.siguienteVisita = siguienteVisita;
	}
	
	public Paciente() {}
	
	public Paciente(PacienteForm form) {
		this.setApellidoMaterno(form.getApellidoMaterno());
		this.setApellidoPaterno(form.getApellidoPaterno());
		this.setCalleynum(form.getCalleynum());
		this.setCiudad(form.getCiudad());
		this.setColonia(form.getColonia());
		this.setCp(form.getCp());
		
		String aux = form.getPais();
		if(aux.equalsIgnoreCase("otro")) {
			this.setEstado(form.getOtroEstado());
			this.setPais(form.getOtroPais());
		} else {
			this.setEstado(form.getEstado());
			this.setPais(aux);
		}
		
		this.setEstadoCivil(form.getEstadoCivil());
		this.setFechaNacimiento(Date.valueOf(LocalDate.parse(form.getYear() + "-" + form.getMonth() + "-" + form.getDay(), DateTimeFormatter.ofPattern("uuuu-M-d"))));
		this.setNombre(form.getNombre());
		this.setOcupacion(form.getOcupacion());
		
		this.setRecomendado(form.getRecomendado().trim());
		this.setRfc(form.getRfc().trim());
		this.setSexo(form.getSexo());
		this.setTelefono(form.getTelefono());
		this.setObservaciones(form.getObservaciones().trim());
	}
	
}
