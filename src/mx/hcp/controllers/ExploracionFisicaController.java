package mx.hcp.controllers;

import java.sql.Date;
import java.time.LocalDate;

import javax.inject.Inject;
import javax.validation.Valid;

import mx.hcp.entities.ExploracionFisica;
import mx.hcp.forms.ExploracionFisicaForm;
import mx.hcp.repositories.ExploracionFisicaRepository;
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
@RequestMapping("exploracionfisica")
@SessionAttributes({"usuario", "paciente", "exploracion"})
public class ExploracionFisicaController {
	@Inject ExploracionFisicaRepository exploracionFisicaRepository;
	
	@RequestMapping(value = "create", method = RequestMethod.GET)
	public ModelAndView create(@ModelAttribute("paciente") PacienteSession paciente, @ModelAttribute("usuario") UsuarioSession usuario) {
		usuario.setCurrent("exploracionFisica");
		ModelAndView view = new ModelAndView("exploracion_fisica/create");
		view.addObject("exploracionFisicaForm", new ExploracionFisicaForm(paciente.getId()));
		return view;
	}
	
	@RequestMapping(value = "create", method = RequestMethod.POST)
	public ModelAndView create(@Valid ExploracionFisicaForm form, Errors errors,
			@ModelAttribute("paciente") PacienteSession paciente) {
		ModelAndView view = new ModelAndView("exploracion_fisica/create");
		if(errors.hasErrors()) {
			view.addObject("exploracionFisicaForm", form);
			return view;
		}
		ExploracionFisica exploracionFisica = new ExploracionFisica();
		
		exploracionFisica.setEstatura(form.getEstatura());
		exploracionFisica.setFrecuenciaCardiaca(form.getFrecuenciaCardiaca());
		exploracionFisica.setFrecuenciaRespiratoria(form.getFrecuenciaRespiratoria());
		exploracionFisica.setGlucosa(form.getGlucosa());
		exploracionFisica.setObservaciones(form.getObservaciones());
		exploracionFisica.setPaciente(form.getPaciente());
		exploracionFisica.setPeso(form.getPeso());
		exploracionFisica.setPesoIdeal(form.getPesoIdeal());
		
		String aux[] = form.getPresion().split("/");
		exploracionFisica.setPresionDiastolica(Integer.parseInt(aux[1]));
		exploracionFisica.setPresionSistolica(Integer.parseInt(aux[0]));
		
		exploracionFisica.setTemperatura(form.getTemperatura());
		exploracionFisica.setFecha(Date.valueOf(LocalDate.now()));
		
		exploracionFisicaRepository.save(exploracionFisica);
		
		paciente.setId(form.getPaciente());
		
		view.clear();
		view.setViewName("redirect:/exploracionfisica/" + form.getPaciente());
		return view;
	}
	
	@RequestMapping(value = "retrieve/{id}", method = RequestMethod.GET)
	public ModelAndView retrieve(@PathVariable("id") ExploracionFisica exploracionFisica, @ModelAttribute("usuario") UsuarioSession usuario) {
		usuario.setCurrent("exploracionFisica");
		ModelAndView view = new ModelAndView("exploracion_fisica/retrieve");
		view.addObject("exploracionFisicaForm", new ExploracionFisicaForm(exploracionFisica));
		return view;
	}
	
	@RequestMapping(value = "update/{id}", method = RequestMethod.GET)
	public ModelAndView update(@PathVariable("id") ExploracionFisica exploracionFisica, @ModelAttribute("usuario") UsuarioSession usuario) {
		usuario.setCurrent("exploracionFisica");
		ModelAndView view = new ModelAndView("exploracion_fisica/create");
		view.addObject("exploracionFisicaForm", new ExploracionFisicaForm(exploracionFisica));
		return view;
	}
	
	@RequestMapping(value = "update/{id}", method = RequestMethod.POST)
	public ModelAndView update(@Valid ExploracionFisicaForm form, Errors errors, 
			@PathVariable("id") ExploracionFisica exploracionFisica) {
		ModelAndView view = new ModelAndView("exploracion_fisica/create");
		if(errors.hasErrors()) {
			view.addObject("exploracionFisicaForm", form);
			return view;
		}
		
		exploracionFisica.setEstatura(form.getEstatura());
		exploracionFisica.setFrecuenciaCardiaca(form.getFrecuenciaCardiaca());
		exploracionFisica.setFrecuenciaRespiratoria(form.getFrecuenciaRespiratoria());
		exploracionFisica.setGlucosa(form.getGlucosa());
		exploracionFisica.setObservaciones(form.getObservaciones());
		exploracionFisica.setPaciente(form.getPaciente());
		exploracionFisica.setPeso(form.getPeso());
		exploracionFisica.setPesoIdeal(form.getPesoIdeal());
		
		String aux[] = form.getPresion().split("/");
		exploracionFisica.setPresionDiastolica(Integer.parseInt(aux[1]));
		exploracionFisica.setPresionSistolica(Integer.parseInt(aux[0]));
		
		exploracionFisica.setTemperatura(form.getTemperatura());
		
		exploracionFisicaRepository.save(exploracionFisica);
		view.clear();
		view.setViewName("redirect:/exploracionfisica/" + form.getPaciente());
		
		return view;
	}
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") ExploracionFisica exploracionFisica) {
		String redirect = "redirect:/exploracionfisica/" + exploracionFisica.getPaciente();
		exploracionFisicaRepository.delete(exploracionFisica);
		return redirect;
	}
	
	@RequestMapping(value = "/{idPaciente}", method = RequestMethod.GET)
	public ModelAndView list(@PathVariable("idPaciente") long idPaciente, Pageable pageable, 
			@ModelAttribute("usuario") UsuarioSession usuario, @ModelAttribute("paciente") PacienteSession paciente) {
		usuario.setCurrent("exploracionFisica");
		ModelAndView view = new ModelAndView("exploracion_fisica/list");
		view.addObject("list", exploracionFisicaRepository.findByPacienteOrderByFechaDescIdDesc(idPaciente, pageable));
		return view;
	}
}
