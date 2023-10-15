package com.naomi.mscomida.service.impl;

import com.naomi.mscomida.domain.dto.ComidaRequestDto;
import com.naomi.mscomida.domain.dto.ComidaResponseDto;
import com.naomi.mscomida.domain.mapper.ComidaMapper;
import com.naomi.mscomida.domain.model.ComidaModel;
import com.naomi.mscomida.exception.ResourceNotFoundException;
import com.naomi.mscomida.service.ComidaService;
import com.naomi.mscomida.repository.ComidaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Comparator;
import java.util.Objects;

import static com.naomi.mscomida.domain.mapper.ComidaMapper.toModel;

@Slf4j
@Service
@RequiredArgsConstructor
public class ComidaImpl implements ComidaService {

    final ComidaRepository comidaRepository;

    @Override
    public Mono<ComidaResponseDto> findById(Integer id) {
        return this.comidaRepository.findById(id)
                .map(ComidaMapper::toDto);
    }

    @Override
    public Flux<ComidaResponseDto> findAll() {
        return this.comidaRepository.findAll()
                .sort(Comparator.comparing(ComidaModel::getId).reversed())
                .map(ComidaMapper::toDto);
    }

    @Override
    public Flux<ComidaResponseDto> findAllActive() {
        return this.comidaRepository.findAll()
                .sort(Comparator.comparing(ComidaModel::getId).reversed())
                .filter(active -> Objects.equals(active.getEstado(), "A"))
                .map(ComidaMapper::toDto);
    }

    @Override
    public Flux<ComidaResponseDto> findAllInactive() {
        return this.comidaRepository.findAll()
                .sort(Comparator.comparing(ComidaModel::getId).reversed())
                .filter(active -> Objects.equals(active.getEstado(), "I"))
                .map(ComidaMapper::toDto);
    }

    @Override
    public Mono<ComidaResponseDto> saveNewLegalGuardian(ComidaRequestDto request) {
        return this.comidaRepository.save(toModel(request))
                .map(ComidaMapper::toDto);
    }

    @Override
    public Mono<ComidaResponseDto> updateLegalGuardian(ComidaRequestDto request, Integer id) {
        return this.comidaRepository.findById(id)
                .switchIfEmpty(Mono.error(new ResourceNotFoundException("El identificador: " + id + "no fue encontrado.")))
                .flatMap(dataFuncionary -> this.comidaRepository.save(toModel(request, dataFuncionary.getId())))
                .map(ComidaMapper::toDto);
    }

    @Override
    public Mono<ComidaResponseDto> deleteLogicalLegalGuardian(Integer id) {
        return this.comidaRepository.findById(id)
                .map((delete) -> {
                    delete.setEstado("I");
                    return delete;
                })
                .flatMap(comidaRepository::save)
                .map(ComidaMapper::toDto);
    }

    @Override
    public Mono<ComidaResponseDto> reactiveLogicalLegalGuardian(Integer id) {
        return this.comidaRepository.findById(id)
                .map((reactive) -> {
                    reactive.setEstado("A");
                    return reactive;
                })
                .flatMap(comidaRepository::save)
                .map(ComidaMapper::toDto);
    }

    @Override
    public Mono<Void> deleteLegalGuardian(Integer id) {
        return this.comidaRepository.deleteById(id); // Borrado Fisico cuidado!
    }
}
