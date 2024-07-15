package test.support;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import test.model.Komponenta;
import test.model.Racun;
import test.service.KomponentaService;
import test.service.ProizvodjacService;
import test.service.RacunService;
import test.web.dto.KomponentaDTO;

@Component
public class KomponentaDTOToKomponenta implements Converter<KomponentaDTO, Komponenta> {

	@Autowired
	private KomponentaService komponentaService;
	
	@Autowired
	private ProizvodjacService proizvodjacService;
	
	@Autowired
	private RacunService racunService;
	
	@Override
	public Komponenta convert(KomponentaDTO dto) {
		Komponenta komponenta;

        if(dto.getId() == null){
        	komponenta = new Komponenta();
        }else{
        	komponenta = komponentaService.findOneById(dto.getId());
        }
        
        if(komponenta != null){
        	komponenta.setCena(dto.getCena());
        	komponenta.setDatumDostupnosti(getLocalDate(dto.getDatumDostupnosti()));
        	komponenta.setDostupnost(dto.getDostupnost());
        	komponenta.setModel(dto.getModel());
        	komponenta.setSlika(dto.getSlika());
        	komponenta.setProizvodjac(proizvodjacService.findOneById(dto.getProizvodjacId()));
        	if(dto.getRacuni() != null) {
	        	List<Racun> racuni = racunService.find(new ArrayList<>(dto.getRacuni().keySet()));
	        	komponenta.setRacuni(racuni);
        	}
        }
        
        return komponenta;
	}
	
	private LocalDate getLocalDate(String date) throws DateTimeParseException {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate datum = LocalDate.parse(date.replace('T', ' ').substring(0, 10), formatter);
		return datum;
	}

}
