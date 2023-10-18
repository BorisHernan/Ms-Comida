package com.naomi.mscomida.domain.dto;

import lombok.AllArgsConstructor;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.annotation.Id;
import lombok.Data;


@Data
@AllArgsConstructor
public class MenuResponseDto {

    @Id
    private int idmenu;
    @Column
    private String nombre;
    @Column
    private String categoria;
    @Column
    private String tipo;
    @Column
    private String estado;
}

//- idmenu / (Id del menu, autoincrementable)
//- nombre / (nombre del menu)
//- categoria  / (menu ejecutivo, menu del dia, menu a la carta, etc
//- tipo   / (desayuno, almuerzo, cena)
//- estado / (A/I)