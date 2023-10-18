package com.naomi.mscomida.service;

import com.naomi.mscomida.domain.dto.MenuRequestDto;
import com.naomi.mscomida.domain.dto.MenuResponseDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public interface MenuService {
    Mono<MenuResponseDto> findById(Integer id);
    Flux<MenuResponseDto> findAll();
    Flux<MenuResponseDto> findAllActive();
    Flux<MenuResponseDto> findAllInactive();
    Mono<MenuResponseDto> saveNewLegalGuardian(MenuRequestDto request);
    Mono<MenuResponseDto> updateLegalGuardian(MenuRequestDto request, Integer id);
    Mono<MenuResponseDto> deleteLogicalLegalGuardian(Integer id);
    Mono<MenuResponseDto> reactiveLogicalLegalGuardian(Integer id);
    Mono<Void> deleteLegalGuardian(Integer id);
}
