package com.naomi.mscomida.domain.mapper;

import com.naomi.mscomida.domain.dto.ComidaRequestDto;
import com.naomi.mscomida.domain.dto.ComidaResponseDto;
import com.naomi.mscomida.domain.model.ComidaModel;

public class ComidaMapper {


    public static ComidaModel toModel(ComidaRequestDto dto) {
        return new ComidaModel(
                dto.getNombre(),
                dto.getDescripcion(),
                dto.getPrecio(),
                dto.getImagen(),
                dto.getCategoria(),
                dto.getEstado()
        );
    }

    public static ComidaModel toModel(ComidaRequestDto dto, Integer id) {
        return new ComidaModel(
                id,
                dto.getNombre(),
                dto.getDescripcion(),
                dto.getPrecio(),
                dto.getImagen(),
                dto.getCategoria(),
                dto.getEstado()
        );
    }

    public static ComidaResponseDto toDto(ComidaModel model) {
        return new ComidaResponseDto(
                model.getId(),
                model.getNombre(),
                model.getDescripcion(),
                model.getPrecio(),
                model.getImagen(),
                model.getCategoria(),
                model.getEstado()
        );
    }
}
