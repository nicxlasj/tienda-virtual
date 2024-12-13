package com.nico.tienda_virtual.persistence.crud;

import com.nico.tienda_virtual.persistence.entity.Compra;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CompraCrudRepository extends CrudRepository<Compra, Integer> {
    Optional<List<Compra>> findByIdUsuario(int idUsuario);
}
