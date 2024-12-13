package com.nico.tienda_virtual.persistence.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "carrito_productos")

public class CarritoProductos {
    @EmbeddedId()
    private CarritoProductosPK id;

    @Column
    private Integer cantidad;

    @ManyToOne
    @JoinColumn(name = "id_usuario", insertable = false, updatable = false)
    private Producto producto;

    @Column
    private Integer total;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    public CarritoProductosPK getId() {
        return id;
    }

    public void setId(CarritoProductosPK id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}
