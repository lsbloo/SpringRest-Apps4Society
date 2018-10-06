package com.apps4society.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.apps4society.annotations.AutenticadoUser;
import com.apps4society.model.Municipios;
import com.apps4society.repository.MunicipioRepository;
import com.apps4society.utilidades.MyCalendar;

@Controller
public class MunicipiosControlerWeb {
	
	@Autowired
	private MunicipioRepository cityRepository;
	
	private MyCalendar mycalendar;
	
	
	
	
	@RequestMapping(value="/listarMunicipios",method=RequestMethod.GET)
	public ModelAndView listCity() {
		ModelAndView mv = new ModelAndView("eventos/listarMunicipios");
		Iterable<Municipios> citys = cityRepository.findAll();
		System.out.println(citys);
		mv.addObject("municipios",citys);
		return mv;
		
	}
	
	@RequestMapping(value="/cadastrarMunicipio",method=RequestMethod.GET)
	public String cadMun() {
		return "eventos/cadcity";
	}
	
	@RequestMapping(value="/cadastrarMunicipio",method=RequestMethod.POST)
	public String cadMunpost(@AutenticadoUser @ModelAttribute Municipios mun,BindingResult resultado) {
		if(resultado.hasErrors()) {
			return "fragments/error";
		}
		System.out.println(mun.getNomecidade());
		List<Municipios> list = cityRepository.checkExist(mun.getNomecidade());
		if(list.size()>1) {
			System.err.println("Municipio Já ADD");
			/*
			 * SE JA EXISTIR UM MUNICIPIO RETORNA PRA UMA VIEW DIFERENTE
			 * coloquei index, mas dps troco
			 */
			return "index";
		}else {
			mycalendar = new MyCalendar();
			System.err.println("XDXD lala" + mun.getNomecidade());
			
			mun.setActived(true);
			cityRepository.save(mun);
			return "eventos/painel_user";
		}
		
	}
	
	

}
