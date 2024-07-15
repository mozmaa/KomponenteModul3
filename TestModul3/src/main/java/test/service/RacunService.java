package test.service;

import java.util.List;

import test.model.Racun;

public interface RacunService {

	Racun save(Racun racun);

	Racun findOneById(Long id);

	List<Racun> findAllByKomponentaId(Long id);

	List<Racun> find(List<Long> ids);

}
