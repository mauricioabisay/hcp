package mx.hcp.controllers;

import java.sql.Date;
import java.time.LocalDate;

import javax.inject.Inject;
import javax.validation.Valid;

import mx.hcp.entities.HistoriaClinica;
import mx.hcp.forms.HistoriaClinicaForm;
import mx.hcp.repositories.HistoriaClinicaRepository;
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
@RequestMapping("historiaclinica")
@SessionAttributes({"usuario", "paciente"})
public class HistoriaClinicaController {
	@Inject HistoriaClinicaRepository historiaClinicaRepository;
	
	@RequestMapping(value = "create", method = RequestMethod.GET)
	public ModelAndView create(@ModelAttribute("paciente") PacienteSession paciente, @ModelAttribute("usuario") UsuarioSession usuario) {
		usuario.setCurrent("historiaClinica");
		ModelAndView view = new ModelAndView("historia_clinica/create");
		
		HistoriaClinicaForm form = new HistoriaClinicaForm(paciente.getId());
		String aux;
		try {
			aux = historiaClinicaRepository.findFirstByPacienteOrderByFechaDescIdDesc(paciente.getId()).getHistoria();
		} catch(Exception e) {
			aux = null;
		}
		if(aux != null) {
			form.setHistoria(aux);
		}
		view.addObject("historiaClinicaForm", form);
		return view;
	}
	
	@RequestMapping(value = "create", method = RequestMethod.POST)
	public ModelAndView create(@Valid HistoriaClinicaForm form, Errors errors) {
		ModelAndView view = new ModelAndView("historia_clinica/create");
		if(errors.hasErrors()) {
			view.addObject("historiaClinicaForm", form);
			return view;
		}
		HistoriaClinica historiaClinica = new HistoriaClinica();
		historiaClinica.setHistoria(form.getHistoria());
		historiaClinica.setPaciente(form.getPaciente());
		historiaClinica.setFecha(Date.valueOf(LocalDate.now()));
		
		historiaClinicaRepository.save(historiaClinica);
		view.clear();
		view.setViewName("redirect:/historiaclinica/" + historiaClinica.getPaciente());
		return view;
	}
	
	@RequestMapping(value = "retrieve/{id}", method = RequestMethod.GET)
	public ModelAndView retrieve(@PathVariable("id") HistoriaClinica historiaClinica, @ModelAttribute("usuario") UsuarioSession usuario) {
		usuario.setCurrent("historiaClinica");
		ModelAndView view = new ModelAndView("historia_clinica/retrieve");
		
		view.addObject("historiaClinicaForm", new HistoriaClinicaForm(historiaClinica));
		
		return view;
	}
	
	@RequestMapping(value = "update/{id}", method = RequestMethod.GET)
	public ModelAndView update(@PathVariable("id") HistoriaClinica historiaClinica, @ModelAttribute("usuario") UsuarioSession usuario) {
		usuario.setCurrent("historiaClinica");
		ModelAndView view = new ModelAndView("historia_clinica/create");
		
		view.addObject("historiaClinicaForm", new HistoriaClinicaForm(historiaClinica));
		
		return view;
	}
	
	@RequestMapping(value = "update/{id}", method = RequestMethod.POST)
	public ModelAndView update(@PathVariable("id") HistoriaClinica historiaClinica, 
			@Valid HistoriaClinicaForm form, Errors errors) {
		ModelAndView view = new ModelAndView("historia_clinica/create");
		
		if(errors.hasErrors()) {
			view.addObject("historiaClinicaForm", form);
			return view;
		}
		
		historiaClinica.setHistoria(form.getHistoria());
		historiaClinicaRepository.save(historiaClinica);
		
		view.setViewName("redirect:/historiaclinica/" + form.getPaciente());
		return view;
	}
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") HistoriaClinica historiaClinica) {
		String redirect = "redirect:/historiaclinica/" + historiaClinica.getPaciente();
		historiaClinicaRepository.delete(historiaClinica);
		return redirect;
	}
	
	@RequestMapping(value = "/{idPaciente}", method = RequestMethod.GET)
	public ModelAndView list(@ModelAttribute("usuario") UsuarioSession usuario,
			@PathVariable("idPaciente") long idPaciente, Pageable pageable) {
		usuario.setCurrent("historiaClinica");
		ModelAndView view = new ModelAndView("historia_clinica/list");
		view.addObject("list", historiaClinicaRepository.findByPacienteOrderByFechaDescIdDesc(idPaciente, pageable));
		return view;
	}
}
