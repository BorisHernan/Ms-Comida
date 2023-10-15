package com.naomi.mscomida.repository;

import com.naomi.mscomida.domain.model.ComidaModel;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComidaRepository extends ReactiveCrudRepository<ComidaModel, Integer> {
}
