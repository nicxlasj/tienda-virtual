package com.nico.tienda_virtual.persistence;

import com.nico.tienda_virtual.domain.dto.Cart;
import com.nico.tienda_virtual.domain.repository.CartRepository;
import com.nico.tienda_virtual.persistence.crud.CarritoCrudRepository;
import com.nico.tienda_virtual.persistence.mapper.CartMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class CarritoRepository implements CartRepository {
    @Autowired
    private CarritoCrudRepository carritoCrudRepository;
    @Autowired
    private CartMapper mapper;

    @Override
    public Cart getByUser(int userId) {
        return mapper.toCart(carritoCrudRepository.findByIdIdUsuario(userId));
    }

    @Override
    public Cart save(Cart cart) {
        return cart;
    }
}
