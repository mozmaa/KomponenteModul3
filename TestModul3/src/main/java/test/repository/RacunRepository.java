package test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import test.model.Racun;

@Repository
public interface RacunRepository extends JpaRepository<Racun, Long> {

	Racun findOneById(Long id);

	List<Racun> findAllByKomponentaId(Long id);

	List<Racun> findByIdIn(List<Long> ids);

}
