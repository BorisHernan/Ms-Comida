package com.soa.canete.transaccional_allocation_soa_canete.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "comida_menu")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransaccionalAllocation {

    @Id
    private Integer id_foodandmenu;
    @Column
    private String categoria;
    @Column
    private String estado;
    @Column("id")
    private Integer id;
    @Column("idmenu")
    private Integer idmenu;

    public TransaccionalAllocation(String categoria, String estado, Integer id, Integer idmenu) {
        this.categoria = categoria;
        this.estado = estado;
        this.id = id;
        this.idmenu = idmenu;
    }

}
