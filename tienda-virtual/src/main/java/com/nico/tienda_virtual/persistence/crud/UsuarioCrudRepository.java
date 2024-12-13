package com.nico.tienda_virtual.persistence.crud;

import com.nico.tienda_virtual.persistence.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UsuarioCrudRepository extends CrudRepository<Usuario, Integer> {
    List<Usuario> findAll();
}
