package mx.hcp.controllers;

import java.sql.Date;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.inject.Inject;
import javax.validation.Valid;

import mx.hcp.entities.ExploracionFisica;
import mx.hcp.entities.Paciente;
import mx.hcp.entities.Padecimiento;
import mx.hcp.entities.Prescripcion;
import mx.hcp.forms.PrescripcionForm;
import mx.hcp.repositories.ExploracionFisicaRepository;
import mx.hcp.repositories.PacienteRepository;
import mx.hcp.repositories.PadecimientoRepository;
import mx.hcp.repositories.PrescripcionRepository;
import mx.hcp.session.PacienteSession;
import mx.hcp.session.UsuarioSession;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("prescripcion")
@SessionAttributes({"usuario", "paciente"})
public class PrescripcionController {
	@Inject PacienteRepository pacienteRepository;
	@Inject PrescripcionRepository prescripcionRepository;
	@Inject ExploracionFisicaRepository exploracionFisicaRepository;
	@Inject PadecimientoRepository padecimientoRepository;
	
	@RequestMapping(value = "create", method = RequestMethod.GET)
	public ModelAndView create(@ModelAttribute("usuario") UsuarioSession usuario, @ModelAttribute("paciente") PacienteSession paciente) {
		usuario.setCurrent("prescripcion");
		ModelAndView view = new ModelAndView("prescripcion/create");
		view.addObject("prescripcionForm", assembleForm(paciente.getId(), usuario.getDiasSiguienteCita()));
		return view;
	}
	
	@RequestMapping(value = "create", method = RequestMethod.POST)
	public ModelAndView create(@Valid PrescripcionForm form, Errors errors) {
		ModelAndView view = new ModelAndView("prescripcion/create");
		if(errors.hasErrors()) {
			view.addObject("prescripcionForm", form);
			return view;
		}
		Prescripcion prescripcion = new Prescripcion();
		prescripcion.setDosis1(form.getDosis1());
		prescripcion.setDosis2(form.getDosis2());
		prescripcion.setDosis3(form.getDosis3());
		prescripcion.setEstatura(form.getEstatura());
		prescripcion.setFrecuenciaCardiaca(form.getFrecuenciaCardiaca());
		prescripcion.setFrecuenciaRespiratoria(form.getFrecuenciaRespiratoria());
		prescripcion.setGlucosa(form.getGlucosa());
		prescripcion.setIndicaciones(form.getIndicaciones());
		prescripcion.setIndicacionesAdicionales(form.getIndicacionesAdicionales());
		prescripcion.setMedicamentos(form.getMedicamentos());
		prescripcion.setPaciente(form.getPaciente());
		prescripcion.setPeso(form.getPeso());
		prescripcion.setPresionDiastolica(form.getPresionDiastolica());
		prescripcion.setPresionSistolica(form.getPresionSistolica());
		prescripcion.setTemperatura(form.getTemperatura());
		
		Date now = Date.valueOf(LocalDate.now());
		prescripcion.setFecha(now);
		Date date = Date.valueOf(LocalDate.parse(form.getSiguienteCita(), DateTimeFormatter.ofPattern("dd/LL/uuuu")));
		prescripcion.setSiguienteCita(date);
		
		prescripcion.setPlantilla(form.getPlantilla());
		
		prescripcionRepository.save(prescripcion);
		
		Paciente paciente = pacienteRepository.findOne(form.getPaciente());
		paciente.setUltimaVisita(now);
		paciente.setSiguienteVisita(date);
		pacienteRepository.save(paciente);
		
		view.clear();
		view.setViewName("redirect:/prescripcion/retrieve/" + prescripcion.getId());
		return view;
	}
	
	@RequestMapping(value = "retrieve/{id}", method = RequestMethod.GET)
	public ModelAndView retrieve(@PathVariable("id") Prescripcion prescripcion,
			@ModelAttribute("usuario") UsuarioSession usuario) {
		usuario.setCurrent("prescripcion");
		ModelAndView view = new ModelAndView("prescripcion/retrieve");
		PrescripcionForm form = new PrescripcionForm(prescripcion);
		LocalDate date = LocalDate.parse(form.getSiguienteCita(), DateTimeFormatter.ofPattern("dd/LL/uuuu"));
		String auxDate = date.format(DateTimeFormatter.ofPattern("EEEE, dd / MMMM / uuuu", Locale.forLanguageTag("es-MX"))).toUpperCase();
		form.setSiguienteCita(auxDate.replaceAll("/", "DE"));
		view.addObject("prescripcionForm", form);
		return view;
	}
	
	@RequestMapping(value = "update/{id}", method = RequestMethod.GET)
	public ModelAndView update(@PathVariable("id") Prescripcion prescripcion,
			@ModelAttribute("usuario") UsuarioSession usuario) {
		usuario.setCurrent("prescripcion");
		ModelAndView view = new ModelAndView("prescripcion/create");
		view.addObject("prescripcionForm", new PrescripcionForm(prescripcion));
		return view;
	}
	
	@RequestMapping(value = "update/{id}", method = RequestMethod.POST)
	public ModelAndView update(@Valid PrescripcionForm form, Errors errors, 
			@PathVariable("id") Prescripcion prescripcion) {
		ModelAndView view = new ModelAndView("prescripcion/create");
		if(errors.hasErrors()) {
			view.addObject("prescripcionForm", form);
			return view;
		}
		prescripcion.setDosis1(form.getDosis1());
		prescripcion.setDosis2(form.getDosis2());
		prescripcion.setDosis3(form.getDosis3());
		prescripcion.setEstatura(form.getEstatura());
		prescripcion.setFrecuenciaCardiaca(form.getFrecuenciaCardiaca());
		prescripcion.setFrecuenciaRespiratoria(form.getFrecuenciaRespiratoria());
		prescripcion.setGlucosa(form.getGlucosa());
		prescripcion.setIndicaciones(form.getIndicaciones());
		prescripcion.setIndicacionesAdicionales(form.getIndicacionesAdicionales());
		prescripcion.setMedicamentos(form.getMedicamentos());
		prescripcion.setPaciente(form.getPaciente());
		prescripcion.setPeso(form.getPeso());
		prescripcion.setPresionDiastolica(form.getPresionDiastolica());
		prescripcion.setPresionSistolica(form.getPresionSistolica());
		prescripcion.setTemperatura(form.getTemperatura());
		prescripcion.setPlantilla(form.getPlantilla());
		Date date = Date.valueOf(LocalDate.parse(form.getSiguienteCita(), DateTimeFormatter.ofPattern("dd/LL/uuuu")));
		prescripcion.setSiguienteCita(date);
		
		prescripcionRepository.save(prescripcion);
		
		Paciente paciente = pacienteRepository.findOne(form.getPaciente());
		paciente.setSiguienteVisita(date);
		pacienteRepository.save(paciente);
		
		view.clear();
		view.setViewName("redirect:/prescripcion/retrieve/" + prescripcion.getId());
		return view;
	}
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") Prescripcion prescripcion) {
		String redirect = "redirect:/prescripcion/" + prescripcion.getPaciente();
		prescripcionRepository.delete(prescripcion);
		return redirect;
	}
	
	@RequestMapping(value = "/{idPaciente}", method = RequestMethod.GET)
	public ModelAndView list(@PathVariable("idPaciente") long idPaciente, Pageable pageable, 
			@ModelAttribute("usuario") UsuarioSession usuario) {
		usuario.setCurrent("prescripcion");
		ModelAndView view = new ModelAndView("prescripcion/list");
		view.addObject("list", prescripcionRepository.findByPacienteOrderByFechaDescIdDesc(idPaciente, pageable));
		return view;
	}
	
	@RequestMapping(value = "create/{plantilla}", method = RequestMethod.POST)
	public ModelAndView plantilla(PrescripcionForm form, @PathVariable("plantilla") int plantilla) {
		ModelAndView view = new ModelAndView("prescripcion/create");
		form.setPlantilla(plantilla);
		switch(plantilla) {
		case 1: {
			form.setIndicaciones(
					"TOMAR LA DOSIS Nº1" 
					+ "\nHOY POR LA NOCHE\n"
					+ "\nMEDICAMENTOS\n"
					+ form.getMedicamentos()
					+ "\n\nTOMAR 3 PASTILLAS CADA DOS HORAS" 
					+ "\nALTERNANDO LOS NÚMEROS"
					+ "\nHASTA TERMINAR DE 8:00 AM a 8:00 PM"
			);
			break;
		}
		case 2: {
			form.setIndicaciones(
					"TOMAR LA DOSIS Nº1" 
					+ "\nHOY POR LA NOCHE" 
					+ "\nY A LOS 15 DÍAS LA DOSIS Nº2\n"
					+ "\nMEDICAMENTOS\n" 
					+ form.getMedicamentos() 
					+ "\n\nTOMAR 3 PASTILLAS CADA DOS HORAS"
					+ "\nALTERNANDO LOS NÚMEROS"
					+ "\nHASTA TERMINAR DE 8:00 AM a 8:00 PM"
			);
			break;
		}
		case 3: {
			form.setIndicaciones(
					"TOMAR LA DOSIS Nº1"
					+ "\nHOY POR LA NOCHE"
					+ "\nY A LOS 15 DÍAS LA DOSIS Nº2\n" +
					"\nMEDICAMENTOS\n" +
					form.getMedicamentos() +
					"\n\nTOMAR 5 GOTAS CADA HORA"
					+ "\nALTERNANDO LOS NÚMEROS"
					+ "\nHASTA TERMINAR DE 8:00 AM a 8:00 PM"
			);
			break;
		}
		case 4: {
			form.setIndicaciones(
					"TOMAR LA DOSIS Nº 1 HOY POR LA NOCHE,"
					+ "\nA LOS 15 DÍAS LA DOSIS Nº2"
					+ "\nY A LOS 15 DÍAS LA DOSIS Nº3\n" +
					"\nMEDICAMENTOS\n" +
					form.getMedicamentos() + 
					"\n\nTOMAR 3 PASTILLAS CADA DOS HORAS"
					+ "\nALTERNANDO LOS NÚMEROS"
					+ "\nHASTA TERMINAR DE 8:00 AM a 6:00 PM"
			);
			break;
		}
		}
		view.addObject("prescripcionForm", form);
		return view;
	}
	
	private PrescripcionForm assembleForm(long paciente, int dias) {
		ExploracionFisica exploracion = null;
		Padecimiento padecimiento = null;
		PrescripcionForm f = new PrescripcionForm(paciente);
		f.setPlantilla(1);
		LocalDate date = LocalDate.now().plusDays(dias);
		if(date.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
			date.plusDays(1);
		}
		f.setSiguienteCita(date.format(DateTimeFormatter.ofPattern("dd/LL/uuuu")));
		try {
			exploracion = exploracionFisicaRepository.findFirstByPacienteOrderByFechaDescIdDesc(paciente);
		}catch(Exception e) {
			f.setExploracionFisica(false);
		}
		try {
			padecimiento = padecimientoRepository.findFirstByPacienteOrderByFechaDescIdDesc(paciente);
		}catch(Exception e) {
			f.setPadecimiento(false);
		}
		
		if(padecimiento != null) {
			f.setPadecimiento(true);
			f.setDosis1(padecimiento.getDosis1());
			f.setDosis2(padecimiento.getDosis2());
			f.setDosis3(padecimiento.getDosis3());
			f.setMedicamentos(padecimiento.getMedicamentos());
		}
		
		if(exploracion != null) {
			f.setExploracionFisica(true);
			f.setEstatura(exploracion.getEstatura());
			f.setFrecuenciaCardiaca(exploracion.getFrecuenciaCardiaca());
			f.setFrecuenciaRespiratoria(exploracion.getFrecuenciaRespiratoria());
			f.setPeso(exploracion.getPeso());
			f.setPresionDiastolica(exploracion.getPresionDiastolica());
			f.setPresionSistolica(exploracion.getPresionSistolica());
			f.setTemperatura(exploracion.getTemperatura());
			f.setGlucosa(exploracion.getGlucosa());
		}
		f.setIndicaciones(
				"TOMAR LA DOSIS Nº1"
				+ "\nHOY POR LA NOCHE\n"
				+ "\nMEDICAMENTOS\n" + 
				f.getMedicamentos() + 
				"\n\nTOMAR 3 PASTILLAS CADA DOS HORAS"
				+ "\nALTERNANDO LOS NÚMEROS"
				+ "\nHASTA TERMINAR DE 8:00 AM a 8:00 PM"
		);
		return f;
	}
}
