package test.support;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import test.model.Komponenta;
import test.model.Proizvodjac;
import test.web.dto.ProizvodjacDTO;


@Component
public class ProizvodjacToProizvodjacDTO implements Converter<Proizvodjac, ProizvodjacDTO> {

	@Override
	public ProizvodjacDTO convert(Proizvodjac proizvodjac) {
		ProizvodjacDTO dto = new ProizvodjacDTO();
        dto.setId(proizvodjac.getId());
        dto.setNaziv(proizvodjac.getNaziv());
        dto.setSediste(proizvodjac.getSediste());
        LinkedHashMap<Long, String> komponentaMap = new LinkedHashMap<>();
        for (Komponenta komponenta: proizvodjac.getKomponente()) {
        	komponentaMap.put(komponenta.getId(), komponenta.getModel());
        }
        dto.setKomponente(komponentaMap);
        return dto;
	}
	
	public List<ProizvodjacDTO> convert(List<Proizvodjac> proizvodjaci){
	    List<ProizvodjacDTO> proizvodjacDTOs = new ArrayList<>();
	
	    for(Proizvodjac proizvodjac: proizvodjaci) {
	    	proizvodjacDTOs.add(convert(proizvodjac));
	    }
	
	    return proizvodjacDTOs;
	}

	
}
