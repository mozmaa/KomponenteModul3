package test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.model.Racun;
import test.repository.RacunRepository;
import test.service.RacunService;

@Service
public class JpaRacunService implements RacunService {

	@Autowired
	private RacunRepository racunRepository;
	
	@Override
	public Racun save(Racun racun) {
		return racunRepository.save(racun);
	}

	@Override
	public Racun findOneById(Long id) {
		return racunRepository.findOneById(id);
	}

	@Override
	public List<Racun> findAllByKomponentaId(Long id) {
		return racunRepository.findAllByKomponentaId(id);
	}

	@Override
	public List<Racun> find(List<Long> ids) {
		return racunRepository.findByIdIn(ids);
	}

}
