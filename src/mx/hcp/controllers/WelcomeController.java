package mx.hcp.controllers;

import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import mx.hcp.entities.Usuario;
import mx.hcp.forms.Campo;
import mx.hcp.repositories.UsuarioRepository;
import mx.hcp.session.PacienteSession;
import mx.hcp.session.UsuarioSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes({"usuario", "paciente"})
public class WelcomeController {
	@Inject UsuarioRepository usuarioRepository;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String login(HttpServletRequest request) {
		return "index";
	}
	
	@RequestMapping(value = "/welcome")
	public ModelAndView welcome(@ModelAttribute("usuario") UsuarioSession usuario) {
		usuario.setCurrent("");
		ModelAndView view = new ModelAndView("redirect:/paciente/");
		view.addObject("paciente", new PacienteSession());
		return view;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam Map<String,String> fullForm) {
		ModelAndView view = new ModelAndView("index");
		
		String usuario, password;
		Campo userCampo, passCampo;
		
		usuario = fullForm.get("user");
		password = fullForm.get("pass");
		userCampo = new Campo(usuario);
		passCampo = new Campo(password);
		
		Usuario usuarioEntity;
		try {
			usuarioEntity = usuarioRepository.findOneByUsuario(usuario);
		} catch(Exception e) {
			usuarioEntity = null;
			return view;
		}
		
		if(usuario == null || usuario.isEmpty()) {
			userCampo.setError(true);
			view.addObject("user", userCampo);
			return view;
		}
		if(password == null || password.isEmpty() || !usuarioEntity.getClave().equals(password)) {
			passCampo.setError(true);
			view.addObject("pass", passCampo);
			return view;
		}
		view.clear();
		view.addObject("usuario", new UsuarioSession(usuarioEntity));
		view.setViewName("redirect:/paciente/");
		return view;
	}
	
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session, ModelMap model) {
		session.invalidate();
		model.clear();
		return "index";
	}
}
