package com.alonso.tienda_backend.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "ventas")
@Data
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "venta_id")
    private Long ventaId;

    @Column(name = "usuario_id")
    private Integer usuarioId;

    @Column(name = "cliente_id")
    private Integer clienteId;

    @Column(name = "metodo_pago_id")
    private Integer metodoPagoId;

    @Column(name = "fecha_venta")
    private LocalDateTime fechaVenta;

    private Double total;
    
    private String estado; // 'COMPLETADA', 'ANULADA'

    // OJO: No guardamos la lista aquí directamente para simplificar el guardado manual
    // Lo haremos a través del Service
    @PrePersist
    protected void onCreate() {
        fechaVenta = LocalDateTime.now();
        if (estado == null) estado = "COMPLETADA";
    }
}