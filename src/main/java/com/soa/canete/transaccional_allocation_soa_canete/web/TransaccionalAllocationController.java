package com.soa.canete.transaccional_allocation_soa_canete.web;

import com.soa.canete.transaccional_allocation_soa_canete.domain.dto.ComidaMenuDetalleTransaccional;
import com.soa.canete.transaccional_allocation_soa_canete.domain.dto.Transaccional.TransaccionalAllocationRequestDto;
import com.soa.canete.transaccional_allocation_soa_canete.domain.model.TransaccionalAllocation;
import com.soa.canete.transaccional_allocation_soa_canete.repository.TransaccionalAllocationRepository;
import com.soa.canete.transaccional_allocation_soa_canete.service.TransaccionalAllocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/transaccionalData")
@RequiredArgsConstructor
public class TransaccionalAllocationController {

    final TransaccionalAllocationRepository transaccionalAllocationRepository;

    final TransaccionalAllocationService transaccionalAllocationService;

    @GetMapping("/{idFamilyData}")
    public Mono<ComidaMenuDetalleTransaccional> getTransaccionDataById(@PathVariable Integer idFamilyData) {
        return this.transaccionalAllocationService.findById(idFamilyData);
    }

    @GetMapping("/listData")
    public Flux<ComidaMenuDetalleTransaccional> getDataCompleteTransaccional() {
        return this.transaccionalAllocationService.findAll();
    }

    @PostMapping
    public Mono<TransaccionalAllocation> saveNewDataTransaccional(@RequestBody TransaccionalAllocationRequestDto dto) {
        return this.transaccionalAllocationService.saveNewDataTransaccional(dto);
    }

}
