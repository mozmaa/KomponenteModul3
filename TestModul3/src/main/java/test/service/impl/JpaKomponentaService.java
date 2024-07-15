package test.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import test.model.Komponenta;
import test.repository.KomponentaRepository;
import test.service.KomponentaService;

@Service
public class JpaKomponentaService implements KomponentaService {

	@Autowired
	private KomponentaRepository komponentaRepository;
	
	@Override
	public List<Komponenta> find(List<Long> ids) {
		return komponentaRepository.findByIdIn(ids);
	}

	@Override
	public Komponenta findOneById(Long komponentaId) {
		return komponentaRepository.findOneById(komponentaId);
	}

	@Override
	public Page<Komponenta> find(String datumOd, String datumDo, Long proizvodjacId, Boolean dostupnost, int pageNo) {
		LocalDate datumOdParam;
		LocalDate datumDoParam;
		
		if(datumOd == null || datumOd == "") {
			datumOdParam = getLocalDate("1000-01-01");
		}else {
			datumOdParam = getLocalDate(datumOd);
		}
		
		if(datumDo == null || datumDo == "") {
			datumDoParam = getLocalDate("9999-12-31");
		}else {
			datumDoParam = getLocalDate(datumDo);
		}
		
		return komponentaRepository.search(datumOdParam, datumDoParam, proizvodjacId, dostupnost, PageRequest.of(pageNo, 2));
	}
	
	private LocalDate getLocalDate(String date) throws DateTimeParseException {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate datum = LocalDate.parse(date.replace('T', ' '), formatter);
		return datum;
	}

	@Override
	public Komponenta save(Komponenta komponenta) {
		return komponentaRepository.save(komponenta);
	}

	@Override
	public Komponenta update(Komponenta komponenta) {
		return komponentaRepository.save(komponenta);
	}

	@Override
	public Komponenta delete(Long id) {
		Komponenta komponenta= findOneById(id);
        if(komponenta != null){
        	komponenta.getProizvodjac().getKomponente().remove(komponenta);
        	komponentaRepository.delete(komponenta);
            return komponenta;
        }
        return null;
	}

}
