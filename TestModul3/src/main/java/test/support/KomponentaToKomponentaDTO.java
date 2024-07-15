package test.support;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import test.model.Komponenta;
import test.model.Racun;
import test.service.RacunService;
import test.web.dto.KomponentaDTO;

@Component
public class KomponentaToKomponentaDTO implements Converter<Komponenta, KomponentaDTO> {

	@Autowired
	private RacunService racunService;
	
	@Override
	public KomponentaDTO convert(Komponenta komponenta) {
		KomponentaDTO dto = new KomponentaDTO();
		dto.setId(komponenta.getId());
		dto.setModel(komponenta.getModel());
		dto.setCena(komponenta.getCena());
		dto.setDatumDostupnosti(komponenta.getDatumDostupnosti().toString());
		dto.setDostupnost(komponenta.isDostupnost());
		dto.setSlika(komponenta.getSlika());
		dto.setProizvodjacId(komponenta.getProizvodjac().getId());
		dto.setProizvodjacNaziv(komponenta.getProizvodjac().getNaziv());
		List<Racun> racuni = racunService.findAllByKomponentaId(komponenta.getId());
		LinkedHashMap<Long, String> racuniMap = new LinkedHashMap<>();
	        for (Racun racun: racuni) {
	        	racuniMap.put(racun.getId(), racun.getDatumIVremeKupovine().toString());
	        }
	    dto.setRacuni(racuniMap);
		return dto;
	}
	
	public List<KomponentaDTO> convert(List<Komponenta> komponente){
        List<KomponentaDTO> komponentaDTOs = new ArrayList<>();

        for(Komponenta komponenta: komponente) {
        	komponentaDTOs.add(convert(komponenta));
        }

        return komponentaDTOs;
    }

}
