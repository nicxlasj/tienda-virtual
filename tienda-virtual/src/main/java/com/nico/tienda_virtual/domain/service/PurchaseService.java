package com.nico.tienda_virtual.domain.service;

import com.nico.tienda_virtual.domain.dto.Purchase;
import com.nico.tienda_virtual.domain.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {
    @Autowired
    private PurchaseRepository purchaseRepository;

    public List<Purchase> getAll() {
        return purchaseRepository.getAll();
    }

    public Optional<List<Purchase>> getByUser(int userId) {
        return purchaseRepository.getPurchaseByUser(userId);
    }
    public Purchase save(Purchase purchase) {
        return purchaseRepository.save(purchase);
    }
}
