package com.nico.tienda_virtual.persistence.mapper;

import com.nico.tienda_virtual.domain.dto.PaymentMethod;
import com.nico.tienda_virtual.persistence.entity.MedioPago;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface PaymentMethodMapper {
    @Mappings({
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "abreviatura", target = "abbreviation")
        }
    )
    PaymentMethod toPaymentMethod(MedioPago medioPago);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "fechaCreacion", ignore = true),
            @Mapping(target = "idMedioPago", ignore = true),
            @Mapping(target = "compras", ignore = true)
    })
    MedioPago toMedioPago(PaymentMethod paymentMethod);

}
