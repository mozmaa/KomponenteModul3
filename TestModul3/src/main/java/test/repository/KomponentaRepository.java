package test.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import test.model.Komponenta;

public interface KomponentaRepository extends JpaRepository<Komponenta, Long> {

	List<Komponenta> findByIdIn(List<Long> ids);

	Komponenta findOneById(Long komponentaId);

	@Query("SELECT k FROM Komponenta k WHERE " +
			"(k.datumDostupnosti BETWEEN :datumOd AND :datumDo) AND " +
			"(:proizvodjacId IS NULL OR k.proizvodjac.id = :proizvodjacId) AND " +
			"(:dostupnost IS NULL OR k.dostupnost = :dostupnost)")
	Page<Komponenta> search(
			@Param ("datumOd") LocalDate datumOdParam,
			@Param ("datumDo") LocalDate datumDoParam, 
			@Param ("proizvodjacId") Long proizvodjacId, 
			@Param ("dostupnost") Boolean dostupnost,
			Pageable pageable);

}
