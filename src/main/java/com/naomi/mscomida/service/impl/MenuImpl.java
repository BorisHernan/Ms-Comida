package com.naomi.mscomida.service.impl;

import com.naomi.mscomida.domain.dto.MenuRequestDto;
import com.naomi.mscomida.domain.dto.MenuResponseDto;
import com.naomi.mscomida.domain.mapper.MenuMapper;
import com.naomi.mscomida.domain.model.MenuModel;
import com.naomi.mscomida.exception.ResourceNotFoundException;
import com.naomi.mscomida.service.MenuService;
import com.naomi.mscomida.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Comparator;
import java.util.Objects;

import static com.naomi.mscomida.domain.mapper.MenuMapper.toModel;

@Slf4j
@Service
@RequiredArgsConstructor
public class MenuImpl implements MenuService {

    final MenuRepository menuRepository;

    @Override
    public Mono<MenuResponseDto> findById(Integer id) {
        return this.menuRepository.findById(id)
                .map(MenuMapper::toDto);
    }

    @Override
    public Flux<MenuResponseDto> findAll() {
        return this.menuRepository.findAll()
                .sort(Comparator.comparing(MenuModel::getIdmenu).reversed())
                .map(MenuMapper::toDto);
    }

    @Override
    public Flux<MenuResponseDto> findAllActive() {
        return this.menuRepository.findAll()
                .sort(Comparator.comparing(MenuModel::getIdmenu).reversed())
                .filter(active -> Objects.equals(active.getEstado(), "A"))
                .map(MenuMapper::toDto);
    }

    @Override
    public Flux<MenuResponseDto> findAllInactive() {
        return this.menuRepository.findAll()
                .sort(Comparator.comparing(MenuModel::getIdmenu).reversed())
                .filter(active -> Objects.equals(active.getEstado(), "I"))
                .map(MenuMapper::toDto);
    }

    @Override
    public Mono<MenuResponseDto> saveNewLegalGuardian(MenuRequestDto request) {
        return this.menuRepository.save(toModel(request))
                .map(MenuMapper::toDto);
    }

    @Override
    public Mono<MenuResponseDto> updateLegalGuardian(MenuRequestDto request, Integer id) {
        return this.menuRepository.findById(id)
                .switchIfEmpty(Mono.error(new ResourceNotFoundException("El identificador: " + id + "no fue encontrado.")))
                .flatMap(dataFuncionary -> this.menuRepository.save(toModel(request, dataFuncionary.getIdmenu())))
                .map(MenuMapper::toDto);
    }

    @Override
    public Mono<MenuResponseDto> deleteLogicalLegalGuardian(Integer id) {
        return this.menuRepository.findById(id)
                .map((delete) -> {
                    delete.setEstado("I");
                    return delete;
                })
                .flatMap(menuRepository::save)
                .map(MenuMapper::toDto);
    }

    @Override
    public Mono<MenuResponseDto> reactiveLogicalLegalGuardian(Integer id) {
        return this.menuRepository.findById(id)
                .map((reactive) -> {
                    reactive.setEstado("A");
                    return reactive;
                })
                .flatMap(menuRepository::save)
                .map(MenuMapper::toDto);
    }

    @Override
    public Mono<Void> deleteLegalGuardian(Integer id) {
        return this.menuRepository.deleteById(id); // Borrado Fisico cuidado!
    }
}
