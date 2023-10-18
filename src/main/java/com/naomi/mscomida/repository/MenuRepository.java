package com.naomi.mscomida.repository;

import com.naomi.mscomida.domain.model.MenuModel;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends ReactiveCrudRepository<MenuModel, Integer> {
}
