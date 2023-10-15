package com.naomi.mscomida.service;

import com.naomi.mscomida.domain.dto.ComidaRequestDto;
import com.naomi.mscomida.domain.dto.ComidaResponseDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface ComidaService {
    Mono<ComidaResponseDto> findById(Integer id);
    Flux<ComidaResponseDto> findAll();
    Flux<ComidaResponseDto> findAllActive();
    Flux<ComidaResponseDto> findAllInactive();
    Mono<ComidaResponseDto> saveNewLegalGuardian(ComidaRequestDto request);
    Mono<ComidaResponseDto> updateLegalGuardian(ComidaRequestDto request, Integer id);
    Mono<ComidaResponseDto> deleteLogicalLegalGuardian(Integer id);
    Mono<ComidaResponseDto> reactiveLogicalLegalGuardian(Integer id);
    Mono<Void> deleteLegalGuardian(Integer id);
}
