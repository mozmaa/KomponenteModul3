package test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.model.Proizvodjac;
import test.repository.ProizvodjacRepository;
import test.service.ProizvodjacService;

@Service
public class JpaProizvodjacService implements ProizvodjacService {

	@Autowired
	private ProizvodjacRepository proizvodjacRepository;
	
	@Override
	public List<Proizvodjac> findAll() {
		return proizvodjacRepository.findAll();
	}

	@Override
	public Proizvodjac save(Proizvodjac proizvodjac) {
		return proizvodjacRepository.save(proizvodjac);
	}

	@Override
	public Proizvodjac findOneById(Long id) {
		return proizvodjacRepository.findOneById(id);
	}

}
