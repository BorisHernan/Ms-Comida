package com.soa.canete.transaccional_allocation_soa_canete.domain.dto.Menu;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;

import java.io.Serial;
import java.io.Serializable;

@Data
@AllArgsConstructor
public class MenuRequestDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 8222253670338491507L;

    @Column
    private String nombre;
    @Column
    private String categoria;
    @Column
    private String tipo;
    @Column
    private String estado;

}
