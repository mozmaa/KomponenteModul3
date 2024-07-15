package test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import test.model.Proizvodjac;

@Repository
public interface ProizvodjacRepository extends JpaRepository<Proizvodjac, Long> {

	Proizvodjac findOneById(Long id);

}
