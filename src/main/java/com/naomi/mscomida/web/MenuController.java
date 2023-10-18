package com.naomi.mscomida.web;

import com.naomi.mscomida.domain.dto.MenuRequestDto;
import com.naomi.mscomida.domain.dto.MenuResponseDto;
import com.naomi.mscomida.repository.MenuRepository;
import com.naomi.mscomida.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/ms-restaurante")
@RequiredArgsConstructor
public class MenuController {

    final MenuService menuService;

    final MenuRepository menuRepository;


    @GetMapping("{id_ou}")
    public Mono<MenuResponseDto> getDataMenuById(@PathVariable Integer id_ou) {
        return this.menuService.findById(id_ou);
    }

    @GetMapping("/listMenu")
    public Flux<MenuResponseDto> getDataMenuComplete() {
        return this.menuService.findAll();
    }


    @GetMapping("/listMenu/activos")
    public Flux<MenuResponseDto> getDataMenuActive() {
        return this.menuService.findAllActive();
    }

    @GetMapping("/listMenu/inactivos")
    public Flux<MenuResponseDto> getDataMenuInactive() {
        return this.menuService.findAllInactive();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Mono<MenuResponseDto> saveNewDataMenu(@RequestBody MenuRequestDto dto) {
        return this.menuService.saveNewLegalGuardian(dto);
    }

    @PutMapping("/{id_ou}")
    public Mono<MenuResponseDto> updateDataMenu(@RequestBody MenuRequestDto dto, @PathVariable Integer id_ou) {
        return this.menuService.updateLegalGuardian(dto, id_ou);
    }

    @PatchMapping("/BorradoLogico/{id_ou}")
    public Mono<MenuResponseDto> deleteLogicalMenu(@PathVariable Integer id_ou) {
        return this.menuService.deleteLogicalLegalGuardian(id_ou);
    }

    @PatchMapping("/reactiveLogical/{id_ou}")
    public Mono<MenuResponseDto> reactiveLogicalMenu(@PathVariable Integer id_ou) {
        return this.menuService.reactiveLogicalLegalGuardian(id_ou);
    }

    @DeleteMapping("/{id_ou}")
    public Mono<Void> deleteTotalMenu(@PathVariable Integer id_ou) {
        return this.menuService.deleteLegalGuardian(id_ou);
    }


}

