package com.nico.tienda_virtual.persistence.crud;

import com.nico.tienda_virtual.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {
    Optional<List<Producto>> findByIdCategoria(int idCategoria);
}
