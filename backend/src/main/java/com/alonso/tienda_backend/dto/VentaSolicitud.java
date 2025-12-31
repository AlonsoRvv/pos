package com.alonso.tienda_backend.dto;

import lombok.Data;
import java.util.List;

@Data
public class VentaSolicitud {
    private Integer usuarioId;
    private Integer clienteId;
    private Integer metodoPagoId;
    private Double total;
    private List<ItemSolicitud> items; // La lista de productos

    @Data
    public static class ItemSolicitud {
        private Integer productoId;
        private Integer cantidad;
        private Double precioUnitario;
        private Double subtotal;
    }
}