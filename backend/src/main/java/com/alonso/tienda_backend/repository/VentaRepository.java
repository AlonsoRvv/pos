package com.alonso.tienda_backend.repository;

import com.alonso.tienda_backend.entity.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentaRepository extends JpaRepository<Venta, Long> {
}