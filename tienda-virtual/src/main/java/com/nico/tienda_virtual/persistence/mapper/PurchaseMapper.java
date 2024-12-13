package com.nico.tienda_virtual.persistence.mapper;

import com.nico.tienda_virtual.domain.dto.Purchase;
import com.nico.tienda_virtual.persistence.entity.Compra;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = { PurchaseItemMapper.class, PaymentMethodMapper.class })
public interface PurchaseMapper {
    @Mappings({
            @Mapping(source = "idCompra", target = "purchaseId"),
            @Mapping(source = "idUsuario", target = "userId"),
            @Mapping(source = "medioPago", target = "paymentMethod"),
            @Mapping(source = "idMedioPago", target = "paymentMethodId"),
            @Mapping(source = "productos", target = "items"),
            @Mapping(source = "fechaCreacion", target = "date")
    })
    Purchase toPurchase(Compra compra);
    List<Purchase> toPurchases(List<Compra> compras);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "usuario", ignore = true)
    })
    Compra toCompra(Purchase purchase);
    List<Compra> toCompras(List<Purchase> purchases);
}
