package com.soa.canete.transaccional_allocation_soa_canete.service.impl;

import com.soa.canete.transaccional_allocation_soa_canete.domain.dto.ComidaMenuDetalleTransaccional;
import com.soa.canete.transaccional_allocation_soa_canete.domain.dto.Menu.MenuResponseDto;
import com.soa.canete.transaccional_allocation_soa_canete.domain.dto.Transaccional.TransaccionalAllocationRequestDto;
import com.soa.canete.transaccional_allocation_soa_canete.domain.model.TransaccionalAllocation;
import com.soa.canete.transaccional_allocation_soa_canete.repository.TransaccionalAllocationRepository;
import com.soa.canete.transaccional_allocation_soa_canete.service.TransaccionalAllocationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.soa.canete.transaccional_allocation_soa_canete.domain.mapper.TransaccionalAllocationMapper.toModel;

@Slf4j
@Service
@RequiredArgsConstructor
public class TransaccionalAllocationImpl implements TransaccionalAllocationService {

    @Autowired private WebClient.Builder webClientBuilder;

    final TransaccionalAllocationRepository transaccionalAllocationRepository;

    @Override
    public Mono<ComidaMenuDetalleTransaccional> findById(Integer id_funcionaryteend) {
        Mono<TransaccionalAllocation> family = transaccionalAllocationRepository.findById(id_funcionaryteend);
        return family.flatMap(dataFamily -> {
            Mono<com.soa.canete.transaccional_allocation_soa_canete.domain.dto.Comida.ComidaResponseDto> funcionaryResponseDtoMono = webClientBuilder.build()
                    .get()
                    .uri("http://localhost:8080/ms-restaurante/" + dataFamily.getId())
                    .retrieve()
                    .bodyToMono(com.soa.canete.transaccional_allocation_soa_canete.domain.dto.Comida.ComidaResponseDto.class);
            Mono<MenuResponseDto> teenResponseDtoMono = webClientBuilder.build()
                    .get()
                    .uri("http://localhost:8081/ms-restaurante/" + dataFamily.getIdmenu())
                    .retrieve()
                    .bodyToMono(MenuResponseDto.class);
            return funcionaryResponseDtoMono.zipWith(teenResponseDtoMono).map(dataGeneral -> {
                com.soa.canete.transaccional_allocation_soa_canete.domain.dto.Comida.ComidaResponseDto legalGuardianResponseDtoData = dataGeneral.getT1();
                MenuResponseDto adolescentResponseDtoData = dataGeneral.getT2();
                ComidaMenuDetalleTransaccional comidaMenuDetalleTransaccional = new ComidaMenuDetalleTransaccional();
                comidaMenuDetalleTransaccional.setTransaccionalAllocation(dataFamily);
                comidaMenuDetalleTransaccional.setMenuResponseDto(adolescentResponseDtoData);
                comidaMenuDetalleTransaccional.setComidaResponseDto(legalGuardianResponseDtoData);
                return comidaMenuDetalleTransaccional;
            });
        });
    }

    @Override
    public Flux<ComidaMenuDetalleTransaccional> findAll() {
        Flux<TransaccionalAllocation> family = transaccionalAllocationRepository.findAll();
        return family.flatMap(dataFamily -> {
            Mono<com.soa.canete.transaccional_allocation_soa_canete.domain.dto.Comida.ComidaResponseDto> funcionaryResponseDtoMono = webClientBuilder.build()
                    .get()
                    .uri("http://localhost:8080/ms-restaurante/" + dataFamily.getId())
                    .retrieve()
                    .bodyToMono(com.soa.canete.transaccional_allocation_soa_canete.domain.dto.Comida.ComidaResponseDto.class);
            Mono<MenuResponseDto> teenResponseDtoMono = webClientBuilder.build()
                    .get()
                    .uri("http://localhost:8081/ms-restaurante/" + dataFamily.getIdmenu())
                    .retrieve()
                    .bodyToMono(MenuResponseDto.class);
            return funcionaryResponseDtoMono.zipWith(teenResponseDtoMono).map(dataGeneral -> {
                com.soa.canete.transaccional_allocation_soa_canete.domain.dto.Comida.ComidaResponseDto legalGuardianResponseDtoData = dataGeneral.getT1();
                MenuResponseDto adolescentResponseDtoData = dataGeneral.getT2();
                ComidaMenuDetalleTransaccional comidaMenuDetalleTransaccional = new ComidaMenuDetalleTransaccional();
                comidaMenuDetalleTransaccional.setTransaccionalAllocation(dataFamily);
                comidaMenuDetalleTransaccional.setMenuResponseDto(adolescentResponseDtoData);
                comidaMenuDetalleTransaccional.setComidaResponseDto(legalGuardianResponseDtoData);
                return comidaMenuDetalleTransaccional;
            });
        });
    }

    @Override
    public Mono<TransaccionalAllocation> saveNewDataTransaccional(TransaccionalAllocationRequestDto request) {
        return this.transaccionalAllocationRepository.save(toModel(request));
    }
}
