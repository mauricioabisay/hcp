package mx.hcp.controllers;

import javax.inject.Inject;
import javax.validation.Valid;

import mx.hcp.entities.Usuario;
import mx.hcp.forms.UsuarioForm;
import mx.hcp.repositories.UsuarioRepository;
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
@RequestMapping("usuario")
@SessionAttributes({"usuario"})
public class UsuarioController {
	@Inject UsuarioRepository usuarioRepository;
	
	@RequestMapping(value = "create", method = RequestMethod.GET)
	public ModelAndView create() {
		ModelAndView view = new ModelAndView("usuario/create");
		view.addObject("usuarioForm", new UsuarioForm());
		return view;
	}
	
	@RequestMapping(value = "create", method = RequestMethod.POST)
	public ModelAndView create(@Valid UsuarioForm form, Errors errors) {
		ModelAndView view = new ModelAndView("usuario/create");
		if(errors.hasErrors()) {
			view.addObject("usuarioForm", form);
			return view;
		}
		
		Usuario usuario = new Usuario();
		usuario.setUsuario(form.getUsuario());
		usuario.setClave(form.getClave());
		usuario.setDiasSiguienteCita(form.getDiasSiguienteVisita());
		usuario.setFirma(form.getFirma());
		
		usuarioRepository.save(usuario);
		view.clear();
		view.setViewName("redirect:/usuario/list");
		return view;
	}
	
	@RequestMapping(value = "retrieve/{id}", method = RequestMethod.GET)
	public ModelAndView retrieve(@PathVariable("id") Usuario usuario) {
		ModelAndView view = new ModelAndView("usuario/retrieve");
		view.addObject("usuarioForm", new UsuarioForm(usuario));
		return view;
	}
	
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public ModelAndView update(@ModelAttribute("usuario") UsuarioSession usuario) {
		ModelAndView view = new ModelAndView("usuario/create");
		view.addObject("usuarioForm", new UsuarioForm(usuarioRepository.findOne(usuario.getIdUsuario())));
		return view;
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public ModelAndView update(@Valid UsuarioForm form, Errors errors) {
		ModelAndView view = new ModelAndView("usuario/create");
		if(errors.hasErrors()) {
			view.addObject("usuarioForm", form);
			return view;
		}
		Usuario usuario = usuarioRepository.findOne(form.getId());
		usuario.setClave(form.getClave());
		usuario.setDiasSiguienteCita(form.getDiasSiguienteVisita());
		usuario.setFirma(form.getFirma());
		usuario.setUsuario(form.getUsuario());
		
		usuarioRepository.save(usuario);
		view.clear();
		view.setViewName("redirect:/usuario/list");
		return view;
	}
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") Usuario usuario) {
		String redirect = "redirect:/usuario/list";
		usuarioRepository.delete(usuario);
		return redirect;
	}
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView list(Pageable pageable, @ModelAttribute("usuario") UsuarioSession usuario) {
		usuario.setCurrent("usuarios");
		ModelAndView view = new ModelAndView("usuario/list");
		view.addObject("list", usuarioRepository.findAll(pageable));
		return view;
	}
	
}
