package com.nico.tienda_virtual.persistence.mapper;

import com.nico.tienda_virtual.domain.dto.Product;
import com.nico.tienda_virtual.persistence.entity.Producto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = { CategoryMapper.class })
public interface ProductMapper {
    @Mappings({
            @Mapping(source = "idProducto", target = "productId"),
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "precio", target = "price"),
            @Mapping(source = "stock", target = "quantity"),
            @Mapping(source = "categoria", target = "category"),
            @Mapping(source = "imagen", target = "image")
    })
    Product toProduct(Producto producto);
    List<Product> toProducts(List<Producto> productos);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "fechaCreacion", ignore = true),
            @Mapping(target = "codigoBarras", ignore = true)
    })
    Producto toProducto(Product product);
    List<Producto> toProductos(List<Product> products);
}
