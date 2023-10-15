package com.naomi.mscomida.domain.model;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Table(name = "comida")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ComidaModel {

    @Id
    private int id;
    @Column
    private String nombre;
    @Column
    private String descripcion;
    @Column
    private String precio;
    @Column
    private String imagen;
    @Column
    private String categoria;
    @Column
    private String estado;

    public ComidaModel (String nombre, String descripcion, String precio, String imagen, String categoria, String estado) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.imagen = imagen;
        this.categoria = categoria;
        this.estado = "A";
    }
}
