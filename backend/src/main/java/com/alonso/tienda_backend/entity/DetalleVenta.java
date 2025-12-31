package com.alonso.tienda_backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "detalle_ventas")
@Data
public class DetalleVenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "detalle_venta_id")
    private Long detalleVentaId;

    @Column(name = "venta_id")
    private Long ventaId;

    @Column(name = "producto_id")
    private Integer productoId;

    private Integer cantidad;

    @Column(name = "precio_unitario")
    private Double precioUnitario;

    private Double subtotal;
}