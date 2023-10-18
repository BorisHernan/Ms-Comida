package com.soa.canete.transaccional_allocation_soa_canete.domain.dto.Transaccional;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.io.Serial;
import java.io.Serializable;

@Data
@AllArgsConstructor
public class TransaccionalAllocationResponseDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 8222253670338491507L;

    @Id
    private Integer id_foodandmenu;
    @Column
    private String categoria;
    @Column("id")
    private Integer id;
    @Column("idmenu")
    private Integer idmenu;
    @Column
    private String estado;

}
