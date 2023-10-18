package com.soa.canete.transaccional_allocation_soa_canete.domain.mapper;

import com.soa.canete.transaccional_allocation_soa_canete.domain.dto.Transaccional.TransaccionalAllocationRequestDto;
import com.soa.canete.transaccional_allocation_soa_canete.domain.dto.Transaccional.TransaccionalAllocationResponseDto;
import com.soa.canete.transaccional_allocation_soa_canete.domain.model.TransaccionalAllocation;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TransaccionalAllocationMapper {

    public static TransaccionalAllocation toModel(TransaccionalAllocationRequestDto dto) {
        return new TransaccionalAllocation(
                dto.getCategoria(),
                dto.getEstado(),
                dto.getId(),
                dto.getIdmenu()
        );
    }

    public static TransaccionalAllocation toModel(TransaccionalAllocationRequestDto dto, Integer id_foodandmenu) {
        return new TransaccionalAllocation(
                id_foodandmenu,
                dto.getCategoria(),
                dto.getEstado(),
                dto.getId(),
                dto.getIdmenu()
        );
    }

    public static TransaccionalAllocationResponseDto toDto(TransaccionalAllocation model) {
        return new TransaccionalAllocationResponseDto(
                model.getId_foodandmenu(),
                model.getCategoria(),
                model.getId(),
                model.getIdmenu(),
                model.getEstado()
        );
    }

}
