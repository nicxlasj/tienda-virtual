package com.nico.tienda_virtual.persistence.mapper;

import com.nico.tienda_virtual.domain.dto.Cart;
import com.nico.tienda_virtual.persistence.entity.CarritoProductos;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = { ProductDTOMapper.class })
public interface CartMapper {
    @Mappings({
            @Mapping(source = "id.idUsuario", target = "userId"),
            @Mapping(source = "id.idProducto", target = "productId"),
            @Mapping(source = "cantidad", target = "quantity"),
            @Mapping(source = "producto", target = "product")
    })
    Cart toCart(CarritoProductos carritoProductos);
    List<Cart> toCarts(List<CarritoProductos> carritoProductos);

    @InheritInverseConfiguration
    @Mapping(target = "fechaCreacion", ignore = true)
    @Mapping(target = "total", ignore = true)
    CarritoProductos toCarritoProductos(Cart cart);
    List<CarritoProductos> toCarritosProductos(List<Cart> carts);


}
