package test.service;

import java.util.List;

import test.model.Proizvodjac;

public interface ProizvodjacService {

	List<Proizvodjac> findAll();

	Proizvodjac save(Proizvodjac proizvodjac);

	Proizvodjac findOneById(Long id);

}
