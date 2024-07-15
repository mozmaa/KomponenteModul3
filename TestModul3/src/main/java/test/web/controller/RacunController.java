package test.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import test.model.Komponenta;
import test.model.Racun;
import test.service.KomponentaService;
import test.service.RacunService;
import test.support.RacunDTOToRacun;
import test.web.dto.RacunDTO;


@RestController
@RequestMapping(value = "/api/racuni", produces = MediaType.APPLICATION_JSON_VALUE)
public class RacunController {
	
	@Autowired
	private RacunService racunService;
	
	@Autowired
	private KomponentaService komponentaService;
	
	@Autowired
	private RacunDTOToRacun toRacun;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RacunDTO> create(@Valid @RequestBody RacunDTO racunDTO){
		Racun racun = toRacun.convert(racunDTO);
		
	 	Komponenta komponenta = komponentaService.findOneById(racunDTO.getKomponentaId());
        if(komponenta == null || komponenta.isDostupnost() == false) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Racun savedRacun = racunService.save(racun);
       
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
