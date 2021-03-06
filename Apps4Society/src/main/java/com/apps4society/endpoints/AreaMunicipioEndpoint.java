package com.apps4society.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.apps4society.repository.AreaInteresseRepository;
import com.apps4society.repository.AreaMunicipioRepository;
import com.apps4society.repository.AtrativoTuristicoRepository;
import com.apps4society.model.AreaMunicipio;
import com.apps4society.model.Municipios;
import java.util.List;
import com.apps4society.model.AreaDeInteresseTuristico;
import com.apps4society.repository.MunicipioRepository;
import com.apps4society.services.AreaMunicipioService;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@RestController
@RequestMapping("/endpointAreaMunicipio")
public class AreaMunicipioEndpoint{

	
	/*
	 * Injetando o service; no EndPoint;
	 */
	
	private final AreaMunicipioService areaMunicipioService;
	
	public AreaMunicipioEndpoint(AreaMunicipioService areaMunicipioService) {
		this.areaMunicipioService=areaMunicipioService;
	}

	@ApiOperation(value="Retorna todos os municipios de uma area de Interesse")
	@ResponseStatus(HttpStatus.ACCEPTED)
	@GetMapping(value="/listarMunicipiosPorArea/{id}")
	public List<AreaMunicipio> listAreaMunicipio(@PathVariable("id") Long id){
		return (List<AreaMunicipio>) areaMunicipioService.searchAllMunicipiosArea(id);
	}
	


	
	
}
