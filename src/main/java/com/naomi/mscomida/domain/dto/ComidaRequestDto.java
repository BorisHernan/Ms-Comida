package com.naomi.mscomida.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Data;


import org.springframework.data.relational.core.mapping.Column;

@Data
@AllArgsConstructor
public class ComidaRequestDto {

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

    //- Id
    //- Nombre
    //- Descripcion
    //- Precio
    //- Imagen
    //- Categoria
}
