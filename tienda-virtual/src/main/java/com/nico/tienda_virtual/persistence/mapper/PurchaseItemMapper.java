package com.nico.tienda_virtual.persistence.mapper;

import com.nico.tienda_virtual.domain.dto.PurchaseItem;
import com.nico.tienda_virtual.persistence.entity.ComprasProducto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = { ProductDTOMapper.class })
public interface PurchaseItemMapper {
    @Mappings({
            @Mapping(source = "id.idCompra", target = "purchaseId"),
            @Mapping(source = "total", target = "total"),
            @Mapping(source = "producto", target = "product"),
            @Mapping(source = "cantidad", target = "quantity")
    })
    PurchaseItem toPurchaseItem(ComprasProducto comprasProducto);
    List<PurchaseItem> toPurchaseItems(List<ComprasProducto> comprasProductos);
    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "fechaCreacion", ignore = true),
            @Mapping(target = "compra", ignore = true)
    })
    ComprasProducto toComprasProducto(PurchaseItem purchaseItem);
    List<ComprasProducto> toComprasProductos(List<PurchaseItem> purchaseItems);


}
