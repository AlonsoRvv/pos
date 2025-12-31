package com.alonso.tienda_backend.repository;

import com.alonso.tienda_backend.entity.DetalleVenta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetalleVentaRepository extends JpaRepository<DetalleVenta, Long> {
}