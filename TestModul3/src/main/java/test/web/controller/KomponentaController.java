package test.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import test.model.Komponenta;
import test.service.KomponentaService;
import test.support.KomponentaDTOToKomponenta;
import test.support.KomponentaToKomponentaDTO;
import test.web.dto.KomponentaDTO;


@RestController
@RequestMapping(value = "/api/komponente", produces = MediaType.APPLICATION_JSON_VALUE)
public class KomponentaController {
	
	@Autowired
	private KomponentaService komponentaService;
	
	@Autowired
	private KomponentaToKomponentaDTO toDTO;
	
	@Autowired
	private KomponentaDTOToKomponenta toKomponenta;

	@PreAuthorize("permitAll()")
	@GetMapping
    public ResponseEntity<List<KomponentaDTO>> getAll(
            @RequestParam(required=false) String datumOd,
            @RequestParam(required=false) String datumDo,
            @RequestParam(required=false) Long proizvodjacId,
            @RequestParam(required=false) Boolean dostupnost,
            @RequestParam(value = "pageNo", defaultValue = "0") int pageNo){

        Page<Komponenta> page = komponentaService.find(datumOd, datumDo, proizvodjacId, dostupnost, pageNo);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Total-Pages", Integer.toString(page.getTotalPages()));

        return new ResponseEntity<>(toDTO.convert(page.getContent()),headers, HttpStatus.OK);
    }
	
	@GetMapping("/{id}")
	 public ResponseEntity<KomponentaDTO> getOne(@PathVariable Long id){
		 Komponenta komponenta= komponentaService.findOneById(id);

	     if(komponenta != null) {
	         return new ResponseEntity<>(toDTO.convert(komponenta), HttpStatus.OK);
	     }else {
	         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	     }
	 }
	
	 @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<KomponentaDTO> create(@Valid @RequestBody KomponentaDTO komponentaDTO){
		 Komponenta komponenta = toKomponenta.convert(komponentaDTO);

	        if(komponentaDTO.getProizvodjacId() == null) {
	            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	        }
	        Komponenta savedKomponenta = komponentaService.save(komponenta);
	        
	        
	        return new ResponseEntity<>(toDTO.convert(savedKomponenta), HttpStatus.CREATED);
	    }
	 
	 @PutMapping(value= "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<KomponentaDTO> update(@PathVariable Long id, @Valid @RequestBody KomponentaDTO komponentaDTO){

	        if(!id.equals(komponentaDTO.getId()) || komponentaDTO.getProizvodjacId() == null) {
	            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	        }

	        Komponenta komponenta = toKomponenta.convert(komponentaDTO);
	        Komponenta savedKomponenta = komponentaService.update(komponenta);

	        return new ResponseEntity<>(toDTO.convert(savedKomponenta),HttpStatus.OK);
	    }
	 
	 @DeleteMapping("/{id}")
	    public ResponseEntity<Void> delete(@PathVariable Long id){
		 Komponenta deletedKomponenta = komponentaService.delete(id);

	        if(deletedKomponenta != null) {
	            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
}
