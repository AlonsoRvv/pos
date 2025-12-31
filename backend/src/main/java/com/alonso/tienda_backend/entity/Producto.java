package com.alonso.tienda_backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "productos")
@Data
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "producto_id") // En tu SQL se llama producto_id
    private Integer productoId;   // En Java lo llamaremos productoId

    @Column(name = "codigo_barras", unique = true)
    private String codigoBarras;

    private String nombre;

    private String descripcion;

    @Column(name = "precio_compra")
    private Double precioCompra;

    @Column(name = "precio_venta")
    private Double precioVenta;

    @Column(name = "stock_actual") // OJO: Cambio importante aquí
    private Integer stockActual;

    @Column(name = "stock_minimo")
    private Integer stockMinimo;

    private Boolean activo;

    // Relaciones simples por ID (luego las haremos completas)
    @Column(name = "categoria_id")
    private Integer categoriaId;

    // Nota: proveedor_id ya no está en la tabla productos en tu nuevo script,
    // está en la tabla 'compras'. Así que lo quitamos de aquí.
}