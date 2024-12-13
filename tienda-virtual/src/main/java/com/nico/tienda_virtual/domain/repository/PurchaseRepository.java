package com.nico.tienda_virtual.domain.repository;

import com.nico.tienda_virtual.domain.dto.Purchase;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {
    List<Purchase> getAll();
    Optional<List<Purchase>> getPurchaseByUser(int userId);
    Purchase save(Purchase purchase);
}
