package test.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import test.model.Komponenta;
import test.model.Proizvodjac;
import test.service.KomponentaService;
import test.service.ProizvodjacService;
import test.web.dto.ProizvodjacDTO;

@Component
public class ProizvodjacDTOToProizvodjac implements Converter<ProizvodjacDTO, Proizvodjac> {

	@Autowired
	private ProizvodjacService proizvodjacService;
	
	@Autowired
	private KomponentaService komponentaService;
	
	@Override
	public Proizvodjac convert(ProizvodjacDTO dto) {
		Proizvodjac proizvodjac;

        if(dto.getId() == null){
        	proizvodjac = new Proizvodjac();
        }else{
        	proizvodjac = proizvodjacService.findOneById(dto.getId());
        }
        
        if(proizvodjac != null){
        	proizvodjac.setNaziv(dto.getNaziv());
        	proizvodjac.setSediste(dto.getSediste());
        	if(dto.getKomponente() != null) {
	        	List<Komponenta> komponente = komponentaService.find(new ArrayList<>(dto.getKomponente().keySet()));
	        	proizvodjac.setKomponente(komponente);
        	}

        }
        
        return proizvodjac;
	}

}
