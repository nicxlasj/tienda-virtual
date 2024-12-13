package com.nico.tienda_virtual.persistence.crud;

import com.nico.tienda_virtual.persistence.entity.CarritoProductos;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarritoCrudRepository extends CrudRepository<CarritoProductos, Integer> {
    CarritoProductos findByIdIdUsuario(int idUsuario);
}
