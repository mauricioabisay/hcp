package mx.hcp.controllers;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.inject.Inject;
import javax.validation.Valid;

import mx.hcp.entities.Estudio;
import mx.hcp.forms.EstudioForm;
import mx.hcp.repositories.EstudioRepository;
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
@RequestMapping("estudio")
@SessionAttributes({"usuario", "paciente"})
public class EstudioController {
	@Inject EstudioRepository estudioRepository;
	
	@RequestMapping(value = "create", method = RequestMethod.GET)
	public ModelAndView create(@ModelAttribute("paciente") PacienteSession paciente) {
		ModelAndView view = new ModelAndView("estudio/create");
		EstudioForm form = new EstudioForm(paciente.getId());
		String aux;
		try {			
			Estudio estudio = estudioRepository.findFirstByPacienteOrderByFechaDescIdDesc(paciente.getId());
			aux = estudio.getFecha().toLocalDate().format(DateTimeFormatter.ofPattern("dd / MMMM / uuuu", Locale.forLanguageTag("es-MX"))).toUpperCase();
			aux += "\n\n" + estudio.getEstudio();
		}catch(Exception e) {
			aux = null;
		}
		if(aux != null) {
			form.setEstudio("\n\n\n" + aux);
		}
		view.addObject("estudioForm", form);
		return view;
	}
	
	@RequestMapping(value = "create", method = RequestMethod.POST)
	public ModelAndView create(@Valid EstudioForm form, Errors errors) {
		ModelAndView view = new ModelAndView("estudio/create");
		if(errors.hasErrors()) {
			view.addObject("estudioForm", form);
			return view;
		}
		Estudio estudio = new Estudio();
		estudio.setEstudio(form.getEstudio());
		estudio.setFecha(Date.valueOf(LocalDate.now()));
		estudio.setPaciente(form.getPaciente());
		
		estudioRepository.save(estudio);
		view.clear();
		view.setViewName("redirect:/estudio/" + form.getPaciente());
		return view;
	}
	
	@RequestMapping(value = "retrieve/{id}", method = RequestMethod.GET)
	public ModelAndView retrieve(@PathVariable("id") Estudio estudio) {
		ModelAndView view = new ModelAndView("estudio/retrieve");
		view.addObject("estudioForm", new EstudioForm(estudio));
		return view;
	}
	
	@RequestMapping(value = "update/{id}", method = RequestMethod.GET)
	public ModelAndView update(@PathVariable("id") Estudio estudio) {
		ModelAndView view = new ModelAndView("estudio/create");
		view.addObject("estudioForm", new EstudioForm(estudio));
		return view;
	}
	
	@RequestMapping(value = "update/{id}", method = RequestMethod.POST)
	public ModelAndView update(@Valid EstudioForm form, Errors errors, @PathVariable("id") Estudio estudio) {
		ModelAndView view = new ModelAndView("estudio/create");
		if(errors.hasErrors()) {
			view.addObject("estudioForm", form);
			return view;
		}
		estudio.setEstudio(form.getEstudio());
		estudio.setPaciente(form.getPaciente());
		
		estudioRepository.save(estudio);
		view.clear();
		view.setViewName("redirect:/estudio/" + form.getPaciente());
		return view;
	}
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") Estudio estudio) {
		String redirect = "redirect:/estudio/" + estudio.getPaciente();
		estudioRepository.delete(estudio);
		return redirect;
	}
	
	@RequestMapping(value = "/{idPaciente}", method = RequestMethod.GET)
	public ModelAndView list(@PathVariable("idPaciente") long paciente, Pageable pageable,
			@ModelAttribute("usuario") UsuarioSession usuario) {
		usuario.setCurrent("estudio");
		ModelAndView view = new ModelAndView("estudio/list");
		view.addObject("list", estudioRepository.findByPacienteOrderByFechaDescIdDesc(paciente, pageable));
		return view;
	}
	
}
