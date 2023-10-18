package com.soa.canete.transaccional_allocation_soa_canete.domain.dto.Comida;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.io.Serial;
import java.io.Serializable;

@Data
@AllArgsConstructor
public class ComidaResponseDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 8222253670338491507L;

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
