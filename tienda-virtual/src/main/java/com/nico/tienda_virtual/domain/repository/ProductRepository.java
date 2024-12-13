package com.nico.tienda_virtual.domain.repository;

import com.nico.tienda_virtual.domain.dto.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Product> getAll();
    Optional<Product> getProduct(int productId);
    Optional<List<Product>> getByCategory(int categoryId);
    Product save(Product product);
    void delete(int productId);

}
