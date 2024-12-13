package com.nico.tienda_virtual.persistence.mapper;

import com.nico.tienda_virtual.domain.dto.ProductDTO;
import com.nico.tienda_virtual.persistence.entity.Producto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = { CategoryMapper.class })
public interface ProductDTOMapper {
    @Mappings({
            @Mapping(source = "idProducto", target = "productId"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "precio", target = "price"),
            @Mapping(source = "categoria", target = "category")
    })
    ProductDTO toProductDTO(Producto producto);
    List<ProductDTO> toProductsDTO(List<Producto> productos);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "idCategoria", ignore = true),
            @Mapping(target = "codigoBarras", ignore = true),
            @Mapping(target = "stock", ignore = true),
            @Mapping(target = "fechaCreacion", ignore = true)
    })
    Producto toProducto(ProductDTO productDTO);
    List<Producto> toProductos(List<ProductDTO> productDTOS);
}
