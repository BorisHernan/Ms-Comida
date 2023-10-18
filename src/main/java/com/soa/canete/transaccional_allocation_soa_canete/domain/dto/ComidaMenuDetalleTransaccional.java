package com.soa.canete.transaccional_allocation_soa_canete.domain.dto;

import com.soa.canete.transaccional_allocation_soa_canete.domain.dto.Comida.ComidaResponseDto;
import com.soa.canete.transaccional_allocation_soa_canete.domain.dto.Menu.MenuResponseDto;
import com.soa.canete.transaccional_allocation_soa_canete.domain.model.TransaccionalAllocation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComidaMenuDetalleTransaccional {

    private ComidaResponseDto comidaResponseDto;
    private MenuResponseDto menuResponseDto;
    private TransaccionalAllocation transaccionalAllocation;

}
