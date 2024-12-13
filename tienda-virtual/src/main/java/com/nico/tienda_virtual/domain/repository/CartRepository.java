package com.nico.tienda_virtual.domain.repository;

import com.nico.tienda_virtual.domain.dto.Cart;

import java.util.List;

public interface CartRepository {
    Cart getByUser(int userId);
    Cart save(Cart cart);
}
