package com.soa.canete.transaccional_allocation_soa_canete.service;

import com.soa.canete.transaccional_allocation_soa_canete.domain.dto.ComidaMenuDetalleTransaccional;
import com.soa.canete.transaccional_allocation_soa_canete.domain.dto.Transaccional.TransaccionalAllocationRequestDto;
import com.soa.canete.transaccional_allocation_soa_canete.domain.model.TransaccionalAllocation;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface TransaccionalAllocationService {

    Mono<ComidaMenuDetalleTransaccional> findById(Integer id_funcionaryteend);
    Flux<ComidaMenuDetalleTransaccional> findAll();
    Mono<TransaccionalAllocation> saveNewDataTransaccional(TransaccionalAllocationRequestDto request);

}
