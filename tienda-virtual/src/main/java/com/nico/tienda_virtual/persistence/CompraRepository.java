package com.nico.tienda_virtual.persistence;

import com.nico.tienda_virtual.domain.dto.Purchase;
import com.nico.tienda_virtual.domain.repository.PurchaseRepository;
import com.nico.tienda_virtual.persistence.crud.CompraCrudRepository;
import com.nico.tienda_virtual.persistence.entity.Compra;
import com.nico.tienda_virtual.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CompraRepository implements PurchaseRepository {
    @Autowired
    private CompraCrudRepository compraCrudRepository;
    @Autowired
    private PurchaseMapper mapper;


    @Override
    public List<Purchase> getAll() {
        return mapper.toPurchases((List<Compra>) compraCrudRepository.findAll());
    }

    @Override
    public Optional<List<Purchase>> getPurchaseByUser(int purchaseId) {
        return compraCrudRepository.findByIdUsuario(purchaseId).
                map(compras -> mapper.toPurchases(compras));
    }

    @Override
    public Purchase save(Purchase purchase) {
        var compra = mapper.toCompra(purchase);
        compra.getProductos().forEach(comprasProducto -> comprasProducto.setCompra(compra));
        compraCrudRepository.save(compra);
        return purchase;
    }
}
