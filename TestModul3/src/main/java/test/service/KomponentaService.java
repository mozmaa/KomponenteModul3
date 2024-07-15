package test.service;

import java.util.List;

import org.springframework.data.domain.Page;

import test.model.Komponenta;

public interface KomponentaService {

	List<Komponenta> find(List<Long> ids);

	Komponenta findOneById(Long komponentaId);

	Page<Komponenta> find(String datumOd, String datumDo, Long proizvodjacId, Boolean dostupnost,
			int pageNo);

	Komponenta save(Komponenta komponenta);

	Komponenta update(Komponenta komponenta);

	Komponenta delete(Long id);

}
