package com.nico.tienda_virtual.domain.service;

import com.nico.tienda_virtual.domain.dto.Product;
import com.nico.tienda_virtual.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll() {
        return productRepository.getAll();
    }

    public Optional<Product> getProduct(int productId) {
        return productRepository.getProduct(productId);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public Boolean delete(int productId) {
        return productRepository.getProduct(productId).map(product -> {
            productRepository.delete(productId);
            return true;
        }).orElse(false);
    }
}
