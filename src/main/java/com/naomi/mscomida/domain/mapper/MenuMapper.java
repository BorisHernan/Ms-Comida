package com.naomi.mscomida.domain.mapper;

import com.naomi.mscomida.domain.dto.MenuRequestDto;
import com.naomi.mscomida.domain.dto.MenuResponseDto;
import com.naomi.mscomida.domain.model.MenuModel;

public class MenuMapper {


    public static MenuModel toModel(MenuRequestDto dto) {
        return new MenuModel(
                dto.getNombre(),
                dto.getCategoria(),
                dto.getTipo(),
                dto.getEstado()
        );
    }

    public static MenuModel toModel(MenuRequestDto dto, Integer idmenu) {
        return new MenuModel(
                idmenu,
                dto.getNombre(),
                dto.getCategoria(),
                dto.getTipo(),
                dto.getEstado()
        );
    }

    public static MenuResponseDto toDto(MenuModel model) {
        return new MenuResponseDto(
                model.getIdmenu(),
                model.getNombre(),
                model.getCategoria(),
                model.getTipo(),
                model.getEstado()
        );
    }
}

//- idmenu / (Id del menu, autoincrementable)
//- nombre / (nombre del menu)
//- categoria  / (menu ejecutivo, menu del dia, menu a la carta, etc
//- tipo   / (desayuno, almuerzo, cena)
//- estado / (A/I)