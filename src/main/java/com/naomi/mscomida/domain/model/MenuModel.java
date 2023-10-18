package com.naomi.mscomida.domain.model;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Table(name = "menu")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuModel {

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

    public MenuModel(String nombre, String categoria, String tipo, String estado) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.tipo = tipo;
        this.estado = "A";
    }
}

//- idmenu / (Id del menu, autoincrementable)
//- nombre / (nombre del menu)
//- categoria  / (menu ejecutivo, menu del dia, menu a la carta, etc
//- tipo   / (desayuno, almuerzo, cena)
//- estado / (A/I)