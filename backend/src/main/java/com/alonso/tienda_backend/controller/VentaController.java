package com.alonso.tienda_backend.controller;

import com.alonso.tienda_backend.dto.VentaSolicitud;
import com.alonso.tienda_backend.entity.DetalleVenta;
import com.alonso.tienda_backend.entity.Venta;
import com.alonso.tienda_backend.repository.DetalleVentaRepository;
import com.alonso.tienda_backend.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ventas")
@CrossOrigin(origins = "http://localhost:5173") // Permiso para React
public class VentaController {

    @Autowired
    private VentaRepository ventaRepository;

    @Autowired
    private DetalleVentaRepository detalleRepository;

    @PostMapping
    @Transactional // Importante: Si algo falla, deshace todo (Rollback)
    public Venta crearVenta(@RequestBody VentaSolicitud solicitud) {
        
        // 1. Crear y Guardar la CABECERA (Venta)
        Venta venta = new Venta();
        venta.setUsuarioId(solicitud.getUsuarioId());
        venta.setClienteId(solicitud.getClienteId());
        venta.setMetodoPagoId(solicitud.getMetodoPagoId());
        venta.setTotal(solicitud.getTotal());
        
        Venta ventaGuardada = ventaRepository.save(venta); // Aquí DB genera el venta_id

        // 2. Guardar los DETALLES
        // Recorremos la lista de items que vino del Frontend
        for (VentaSolicitud.ItemSolicitud item : solicitud.getItems()) {
            DetalleVenta detalle = new DetalleVenta();
            detalle.setVentaId(ventaGuardada.getVentaId()); // Usamos el ID recién generado
            detalle.setProductoId(item.getProductoId());
            detalle.setCantidad(item.getCantidad());
            detalle.setPrecioUnitario(item.getPrecioUnitario());
            detalle.setSubtotal(item.getSubtotal());
            
            detalleRepository.save(detalle);
            // ALERTA: Al guardar esto, el TRIGGER de MySQL se activa y resta el stock solo.
        }

        return ventaGuardada; // Devolvemos la venta con su ID y Fecha para el ticket
    }
}