package mx.hcp.controllers;

import java.text.DecimalFormat;

import javax.inject.Inject;

import mx.hcp.entities.PesoSegunAlturaNinas;
import mx.hcp.entities.PesoSegunAlturaNinos;
import mx.hcp.repositories.PesoSegunAlturaNinasRepository;
import mx.hcp.repositories.PesoSegunAlturaNinosRepository;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("peso")
public class PesoIdealRestController {
	@Inject PesoSegunAlturaNinasRepository ninas;
	@Inject PesoSegunAlturaNinosRepository ninos;
	
	@RequestMapping(value = "/{estatura}/{sexo}", method = RequestMethod.GET)
	public String pesoIdeal(@PathVariable("estatura") double estatura, @PathVariable("sexo") String sexo) {
		DecimalFormat format = new DecimalFormat("###.##");
		double limiteInferior = 0, limiteSuperior = 0;
		
		if(estatura < 3) {
			estatura = estatura*100;
		}
		if(estatura > 120) {
			estatura = estatura/100;
			limiteInferior = 18.5 * Math.pow(estatura, 2);
			limiteSuperior = 24.99 * Math.pow(estatura, 2);
		} else {
			estatura = Double.parseDouble(new DecimalFormat("###.###").format(estatura));
			try {
				if(sexo.equalsIgnoreCase("mujer")) {
					PesoSegunAlturaNinas peso;
					peso = ninas.findOne(estatura);
					limiteInferior = peso.getSD1neg();
					limiteSuperior = peso.getSD1();
				} else {
					PesoSegunAlturaNinos peso;
					peso = ninos.findOne(estatura);
					limiteInferior = peso.getSD1neg();
					limiteSuperior = peso.getSD1();
				}
			} catch(Exception e) {
				limiteInferior = 0;
				limiteSuperior =0;
			}
			
		}
		
		return format.format(limiteInferior) + "kg." + "-" + format.format(limiteSuperior) + "kg.";
	}
	
}
