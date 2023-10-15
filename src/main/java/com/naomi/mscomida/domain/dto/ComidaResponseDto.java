package com.naomi.mscomida.domain.dto;

import lombok.AllArgsConstructor;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.annotation.Id;
import lombok.Data;


@Data
@AllArgsConstructor
public class ComidaResponseDto {

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
}
