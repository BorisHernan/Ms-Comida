package com.naomi.mscomida.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Data;


import org.springframework.data.relational.core.mapping.Column;

@Data
@AllArgsConstructor
public class MenuRequestDto {

@Column
private String nombre;
@Column
private String categoria;
@Column
private String tipo;
@Column
private String estado;

//- idmenu / (Id del menu, autoincrementable)
//- nombre / (nombre del menu)
//- categoria  / (menu ejecutivo, menu del dia, menu a la carta, etc
//- tipo   / (desayuno, almuerzo, cena)
//- estado / (A/I)
}
