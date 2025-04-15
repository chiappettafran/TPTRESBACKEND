package org.example.tptresbackend.repositories;

import org.example.tptresbackend.entities.Instrumento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstrumentoRepository extends CrudRepository<Instrumento, Long> {
}
