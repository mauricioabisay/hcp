package mx.hcp.controllers;

import java.time.LocalDate;

import javax.inject.Inject;
import javax.validation.Valid;

import mx.hcp.entities.Paciente;
import mx.hcp.forms.ExploracionFisicaForm;
import mx.hcp.forms.PacienteForm;
import mx.hcp.forms.SearchForm;
import mx.hcp.repositories.EstudioRepository;
import mx.hcp.repositories.ExploracionFisicaRepository;
import mx.hcp.repositories.HistoriaClinicaRepository;
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
@RequestMapping("paciente")
@SessionAttributes({"usuario", "paciente", "searchForm"})
public class PacienteController {
	@Inject PacienteRepository pacienteRepository;
	@Inject EstudioRepository estudio;
	@Inject ExploracionFisicaRepository exploracion;
	@Inject HistoriaClinicaRepository historia;
	@Inject PadecimientoRepository padecimiento;
	@Inject PrescripcionRepository prescripcion;
	
	@RequestMapping(value = "create", method = RequestMethod.GET)
	public ModelAndView create(@ModelAttribute("usuario") UsuarioSession usuario) {
		usuario.setCurrent("datosPaciente");
		ModelAndView view = new ModelAndView("paciente/create");
		view.addObject("paciente", new PacienteSession());
		view.addObject("pacienteForm", new PacienteForm());
		return view;
	}
	
	@RequestMapping(value = "create", method = RequestMethod.POST)
	public ModelAndView create(@Valid PacienteForm form, Errors errors) {
		ModelAndView view = new ModelAndView("paciente/create");
		
		if(errors.hasErrors()) {
			view.addObject("errors", errors.getAllErrors());
			view.addObject("pacienteForm", form);
			return view;
		}
		
		String auxDate[] = form.getFechaNacimientoString().split("-");
		int day = 0, month = 0, year = 0;
		try {
			day = Integer.parseInt(auxDate[0]);
		} catch(Exception e) {
			view.addObject("fechaError", true);
			view.addObject("pacienteForm", form);
			return view;
		}
		try {
			month = Integer.parseInt(auxDate[1]);
		} catch(Exception e) {
			view.addObject("fechaError", true);
			view.addObject("pacienteForm", form);
			return view;
		}
		try {
			year = Integer.parseInt(auxDate[2]);
		} catch(Exception e) {
			view.addObject("fechaError", true);
			view.addObject("pacienteForm", form);
			return view;
		}
		
		try {
			String parse = year + "-";
			parse+= (month>9) ? month : "0" + month;
			parse+= "-";
			parse+= (day>9) ? day : "0" + day;
			LocalDate.parse(parse);
		} catch(Exception e) {
			view.addObject("fechaError", true);
			view.addObject("pacienteForm", form);
			return view;
		}
		
		form.setDay(day);
		form.setMonth(month);
		form.setYear(year);
		
		Paciente paciente = new Paciente(form);
		pacienteRepository.save(paciente);
		
		view.clear();
		view.setViewName("redirect:/paciente/retrieve/" + paciente.getId());
		return view;
	}
	
	@RequestMapping(value = "retrieve/{id}", method = RequestMethod.GET)
	public ModelAndView retrieve(@PathVariable("id") Paciente paciente, @ModelAttribute("usuario") UsuarioSession usuario) {
		usuario.setCurrent("datosPaciente");
		ModelAndView view = new ModelAndView("paciente/retrieve");
		ExploracionFisicaForm exploracion;
		try {
			exploracion = new ExploracionFisicaForm(
						this.exploracion.findFirstByPacienteOrderByFechaDescIdDesc(paciente.getId())
					);
		}catch(Exception e) {
			exploracion = null;
		}
		view.addObject("paciente", new PacienteSession(paciente, exploracion));
		view.addObject("pacienteForm", new PacienteForm(paciente));
		return view;
	}
	
	@RequestMapping(value = "update/{id}", method = RequestMethod.GET)
	public ModelAndView update(@PathVariable("id") Paciente paciente, @ModelAttribute("usuario") UsuarioSession usuario) {
		usuario.setCurrent("datosPaciente");
		ModelAndView view = new ModelAndView("paciente/create");
		ExploracionFisicaForm exploracion;
		try {
			exploracion = new ExploracionFisicaForm(
						this.exploracion.findFirstByPacienteOrderByFechaDescIdDesc(paciente.getId())
					);
		}catch(Exception e) {
			exploracion = null;
		}
		view.addObject("paciente", new PacienteSession(paciente, exploracion));
		PacienteForm form = new PacienteForm(paciente);
		form.setFechaNacimientoString(form.getDay() + "-" + form.getMonth() + "-" + form.getYear());
		view.addObject("pacienteForm", form);
		return view;
	}
	
	@RequestMapping(value = "update/{id}", method = RequestMethod.POST)
	public ModelAndView update(@Valid PacienteForm form, Errors errors) {
		ModelAndView view = new ModelAndView("paciente/create");
		if(errors.hasErrors()) {
			view.addObject("errors", errors.getAllErrors());
			view.addObject("pacienteForm", form);
			return view;
		}
		
		String auxDate[] = form.getFechaNacimientoString().split("-");
		int day = 0, month = 0, year = 0;
		try {
			day = Integer.parseInt(auxDate[0]);
		} catch(Exception e) {
			view.addObject("fechaError", true);
			view.addObject("pacienteForm", form);
			return view;
		}
		try {
			month = Integer.parseInt(auxDate[1]);
		} catch(Exception e) {
			view.addObject("fechaError", true);
			view.addObject("pacienteForm", form);
			return view;
		}
		try {
			year = Integer.parseInt(auxDate[2]);
		} catch(Exception e) {
			view.addObject("fechaError", true);
			view.addObject("pacienteForm", form);
			return view;
		}
		
		try {
			String parse = year + "-";
			parse+= (month>9) ? month : "0" + month;
			parse+= "-";
			parse+= (day>9) ? day : "0" + day;
			LocalDate.parse(parse);
		} catch(Exception e) {
			view.addObject("fechaError", true);
			view.addObject("pacienteForm", form);
			return view;
		}
		
		form.setDay(day);
		form.setMonth(month);
		form.setYear(year);
		
		Paciente paciente = new Paciente(form);
		paciente.setId(form.getId());
		pacienteRepository.save(paciente);
		
		view.clear();
		view.setViewName("redirect:/paciente/retrieve/" + paciente.getId());
		return view;
	}
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") long paciente) {
		estudio.deleteByPaciente(paciente);
		exploracion.deleteByPaciente(paciente);
		historia.deleteByPaciente(paciente);
		padecimiento.deleteByPaciente(paciente);
		prescripcion.deleteByPaciente(paciente);
		pacienteRepository.delete(paciente);
		return "redirect:/paciente/";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView search(@ModelAttribute UsuarioSession usuario) {
		ModelAndView view = new ModelAndView("main");
		view.addObject("searchForm", new SearchForm());
		//view.addObject("paciente", null);
		return view;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ModelAndView search(@Valid SearchForm form, Errors errors, Pageable pageable) {
		ModelAndView view = new ModelAndView("main");
		view.addObject("paciente", new PacienteSession());
		if(errors.hasErrors()) {
			view.addObject("searchForm", form);
			return view;
		}
		
		if(form.getNombre().equals("")) {
			view.addObject("pacientes", pacienteRepository.findAll(pageable));
		} else {
			//Implementar busqueda por fecha, al igual que eliminacion selectiva
			String search = "%" + form.getNombre() + "%";
			view.addObject(
					"pacientes", 
					pacienteRepository.findByNombreLikeIgnoreCaseOrApellidoPaternoLikeIgnoreCaseOrApellidoMaternoLikeIgnoreCase(
							search, 
							search, 
							search,
							pageable
					));
		}
		view.addObject("searchForm", form);
		return view;
	}
	
	@RequestMapping(value = "page", method = RequestMethod.GET)
	public ModelAndView page(@ModelAttribute SearchForm form, Pageable pageable) {
		ModelAndView view = new ModelAndView("main");
		
		if(form.getNombre().equals("")) {
			view.addObject("pacientes", pacienteRepository.findAll(pageable));
		} else {
			String search = "%" + form.getNombre() + "%";
			view.addObject(
					"pacientes", 
					pacienteRepository.findByNombreLikeIgnoreCaseOrApellidoPaternoLikeIgnoreCaseOrApellidoMaternoLikeIgnoreCase(
							search, 
							search, 
							search,
							pageable
					));
		}
		return view;
	}
}
