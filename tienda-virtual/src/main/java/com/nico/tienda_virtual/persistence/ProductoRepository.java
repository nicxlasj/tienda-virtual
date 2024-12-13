package com.nico.tienda_virtual.persistence;

import com.nico.tienda_virtual.domain.dto.Product;
import com.nico.tienda_virtual.domain.repository.ProductRepository;
import com.nico.tienda_virtual.persistence.crud.ProductoCrudRepository;
import com.nico.tienda_virtual.persistence.entity.Producto;
import com.nico.tienda_virtual.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository implements ProductRepository {
    @Autowired
    private ProductoCrudRepository productoCrudRepository;
    @Autowired
    private ProductMapper mapper;


    @Override
    public List<Product> getAll() {
        return mapper.toProducts((List<Producto>) productoCrudRepository.findAll());
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        var producto = productoCrudRepository.findById(productId);
        return producto.map(producto1 -> mapper.toProduct(producto1));
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        var productos = productoCrudRepository.findByIdCategoria(categoryId);
        return productos.map(productos1 -> mapper.toProducts(productos1));
    }

    @Override
    public Product save(Product product) {
        productoCrudRepository.save(mapper.toProducto(product));
        return product;
    }

    @Override
    public void delete(int productId) {
        productoCrudRepository.deleteById(productId);
    }
}
