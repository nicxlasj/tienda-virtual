package com.nico.tienda_virtual.persistence.mapper;

import com.nico.tienda_virtual.domain.dto.Category;
import com.nico.tienda_virtual.persistence.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mappings({
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "nombre", target = "name")
    })
    Category toCategory(Categoria categoria);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "productos", ignore = true),
            @Mapping(target = "fechaCreacion", ignore = true)
    })
    Categoria toCategoria(Category category);
}
