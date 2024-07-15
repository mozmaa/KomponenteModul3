package test.support;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import test.model.Racun;
import test.service.KomponentaService;
import test.service.RacunService;
import test.web.dto.RacunDTO;

@Component
public class RacunDTOToRacun implements Converter<RacunDTO, Racun> {

	@Autowired
	private RacunService racunService;
	
	@Autowired
	private KomponentaService komponentaService;
	
	@Override
	public Racun convert(RacunDTO dto) {
		Racun racun;

        if(dto.getId() == null){
        	racun = new Racun();
        }else{
        	racun = racunService.findOneById(dto.getId());
        }
        
        if(racun != null){
        	racun.setDatumIVremeKupovine(getLocalDateTime(dto.getDatumIVremeKupovine()));
        	racun.setKomponenta(komponentaService.findOneById(dto.getKomponentaId()));

        }
        
        return racun;	
    }
	
	private LocalDateTime getLocalDateTime(String datumIVreme) throws DateTimeParseException {
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	LocalDate datum = LocalDate.parse(datumIVreme.replace('T', ' ').substring(0, 10), formatter);
	LocalTime vreme = LocalTime.parse(datumIVreme.substring(11), DateTimeFormatter.ofPattern("HH:mm"));
	return LocalDateTime.of(datum, vreme);
}

}
