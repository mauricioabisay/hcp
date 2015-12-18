package mx.hcp.controllers;

import java.sql.Date;
import java.time.LocalDate;

import javax.inject.Inject;
import javax.validation.Valid;

import mx.hcp.entities.Padecimiento;
import mx.hcp.forms.PadecimientoForm;
import mx.hcp.repositories.PadecimientoRepository;
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
@RequestMapping("padecimiento")
@SessionAttributes({"usuario", "paciente"})
public class PadecimientoController {
	@Inject PadecimientoRepository padecimientoRepository;
	
	@RequestMapping(value = "create", method = RequestMethod.GET)
	public ModelAndView create(@ModelAttribute("paciente") PacienteSession paciente, @ModelAttribute("usuario") UsuarioSession usuario) {
		usuario.setCurrent("padecimiento");
		ModelAndView view = new ModelAndView("padecimiento/create");
		view.addObject("padecimientoForm", new PadecimientoForm(paciente.getId()));
		return view;
	}
	
	@RequestMapping(value = "create", method = RequestMethod.POST)
	public ModelAndView create(@Valid PadecimientoForm form, Errors errors) {
		ModelAndView view = new ModelAndView("padecimiento/create");
		if(errors.hasErrors()) {
			view.addObject("padecimientoForm", form);
			return view;
		}
		Padecimiento padecimiento = new Padecimiento();
		padecimiento.setDosis1(form.getDosis1());
		padecimiento.setDosis2(form.getDosis2());
		padecimiento.setDosis3(form.getDosis3());
		padecimiento.setFecha(Date.valueOf(LocalDate.now()));
		padecimiento.setMedicamentos(form.getMedicamentos());
		padecimiento.setPaciente(form.getPaciente());
		padecimiento.setSintomas(form.getSintomas());
		
		padecimientoRepository.save(padecimiento);
		view.clear();
		view.setViewName("redirect:/padecimiento/" + form.getPaciente());
		return view;
	}
	
	@RequestMapping(value = "retrieve/{id}", method = RequestMethod.GET)
	public ModelAndView retrieve(@PathVariable("id") Padecimiento padecimiento) {
		ModelAndView view = new ModelAndView("padecimiento/retrieve");
		view.addObject("padecimientoForm", new PadecimientoForm(padecimiento));
		return view;
	}
	
	@RequestMapping(value = "update/{id}", method = RequestMethod.GET)
	public ModelAndView update(@PathVariable("id") Padecimiento padecimiento, @ModelAttribute("usuario") UsuarioSession usuario) {
		usuario.setCurrent("padecimiento");
		ModelAndView view = new ModelAndView("padecimiento/create");
		view.addObject("padecimientoForm", new PadecimientoForm(padecimiento));
		return view;
	}
	
	@RequestMapping(value = "update/{id}", method = RequestMethod.POST)
	public ModelAndView update(@Valid PadecimientoForm form, Errors errors, @PathVariable("id") Padecimiento padecimiento) {
		ModelAndView view = new ModelAndView("padecimiento/create");
		if(errors.hasErrors()) {
			view.addObject("padecimientoForm", form);
			return view;
		}
		padecimiento.setDosis1(form.getDosis1());
		padecimiento.setDosis2(form.getDosis2());
		padecimiento.setDosis3(form.getDosis3());
		padecimiento.setMedicamentos(form.getMedicamentos());
		padecimiento.setPaciente(form.getPaciente());
		padecimiento.setSintomas(form.getSintomas());
		
		padecimientoRepository.save(padecimiento);
		view.clear();
		view.setViewName("redirect:/padecimiento/" + form.getPaciente());
		return view;
	}
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") Padecimiento padecimiento) {
		String redirect = "redirect:/padecimiento/" + padecimiento.getPaciente();
		padecimientoRepository.delete(padecimiento);
		return redirect;
	}
	
	
	@RequestMapping(value = "/{idPaciente}", method = RequestMethod.GET)
	public ModelAndView list(@PathVariable("idPaciente") long idPaciente, Pageable pageable,
			@ModelAttribute("usuario") UsuarioSession usuario) {
		usuario.setCurrent("padecimiento");
		ModelAndView view = new ModelAndView("padecimiento/list");
		view.addObject("list", padecimientoRepository.findByPacienteOrderByFechaDescIdDesc(idPaciente, pageable));
		return view;
	}
	
}
