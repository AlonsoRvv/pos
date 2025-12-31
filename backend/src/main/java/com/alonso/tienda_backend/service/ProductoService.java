package com.alonso.tienda_backend.service;

import com.alonso.tienda_backend.entity.Producto;
import com.alonso.tienda_backend.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> obtenerTodos() {
        return productoRepository.findAll();
    }

    public Producto guardarProducto(Producto producto) {
        // Aquí podrías validar cosas antes de guardar
        return productoRepository.save(producto);
    }
}