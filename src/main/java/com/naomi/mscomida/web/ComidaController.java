package com.naomi.mscomida.web;

import com.naomi.mscomida.domain.dto.ComidaRequestDto;
import com.naomi.mscomida.domain.dto.ComidaResponseDto;
import com.naomi.mscomida.repository.ComidaRepository;
import com.naomi.mscomida.service.ComidaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import com.naomi.mscomida.repository.ComidaRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/ms-restaurante")
@RequiredArgsConstructor
public class ComidaController {

    final ComidaService comidaService;

    final ComidaRepository comidaRepository;


    @GetMapping("{id_ou}")
    public Mono<ComidaResponseDto> getDataComidaById(@PathVariable Integer id_ou) {
        return this.comidaService.findById(id_ou);
    }

    @GetMapping("/listComida")
    public Flux<ComidaResponseDto> getDataComidaComplete() {
        return this.comidaService.findAll();
    }


    @GetMapping("/listComida/activos")
    public Flux<ComidaResponseDto> getDataFuncionaryActive() {
        return this.comidaService.findAllActive();
    }

    @GetMapping("/listComida/inactivos")
    public Flux<ComidaResponseDto> getDataFuncionaryInactive() {
        return this.comidaService.findAllInactive();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Mono<ComidaResponseDto> saveNewDataComida(@RequestBody ComidaRequestDto dto) {
        return this.comidaService.saveNewLegalGuardian(dto);
    }

    @PutMapping("/{id_ou}")
    public Mono<ComidaResponseDto> updateDataFuncionary(@RequestBody ComidaRequestDto dto, @PathVariable Integer id_ou) {
        return this.comidaService.updateLegalGuardian(dto, id_ou);
    }

    @PatchMapping("/BorradoLogico/{id_ou}")
    public Mono<ComidaResponseDto> deleteLogicalFuncionary(@PathVariable Integer id_ou) {
        return this.comidaService.deleteLogicalLegalGuardian(id_ou);
    }

    @PatchMapping("/reactiveLogical/{id_ou}")
    public Mono<ComidaResponseDto> reactiveLogicalFuncionary(@PathVariable Integer id_ou) {
        return this.comidaService.reactiveLogicalLegalGuardian(id_ou);
    }

    @DeleteMapping("/{id_ou}")
    public Mono<Void> deleteTotalFuncionary(@PathVariable Integer id_ou) {
        return this.comidaService.deleteLegalGuardian(id_ou);
    }


}

