package test.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import test.model.Proizvodjac;
import test.service.ProizvodjacService;
import test.support.ProizvodjacDTOToProizvodjac;
import test.support.ProizvodjacToProizvodjacDTO;
import test.web.dto.ProizvodjacDTO;


@RestController
@RequestMapping(value = "/api/proizvodjaci", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProizvodjacController {

	@Autowired
	private ProizvodjacService proizvodjacService;
	
	@Autowired
	private ProizvodjacToProizvodjacDTO toDTO;
	
	@Autowired
	private ProizvodjacDTOToProizvodjac toProizvodjac;
	
	@GetMapping()
	public ResponseEntity<List<ProizvodjacDTO>> getAll(){
		List<Proizvodjac> sprintovi = proizvodjacService.findAll();
		return new ResponseEntity<> (toDTO.convert(sprintovi), HttpStatus.OK);
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProizvodjacDTO> create(@Valid @RequestBody ProizvodjacDTO proizvodjacDTO){
		Proizvodjac proizvodjac = toProizvodjac.convert(proizvodjacDTO);
        Proizvodjac savePrevoznik = proizvodjacService.save(proizvodjac);
        
        
        return new ResponseEntity<>(toDTO.convert(savePrevoznik), HttpStatus.CREATED);
    }
}
