package com.alonso.tienda_backend.repository;

import com.alonso.tienda_backend.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    // Aquí puedes crear métodos mágicos como:
    // Producto findByCodigoBarras(String codigo);
}