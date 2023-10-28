package com.example.modeladov1.service;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import com.example.modeladov1.model.Resena;
import com.example.modeladov1.repository.ResenaRepository;
import com.example.modeladov1.model.Producto;
import com.example.modeladov1.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResenaService {
    @Autowired
    ResenaRepository repo;

    @Autowired
    UsuarioService usuarioService; // Inyecta usuarioService

    @Autowired
    ProductoService productoService; // Inyecta productoService

    public List<Resena> getAll(){
        List<Resena> resenas = new ArrayList<>();
        for(Resena resena : repo.findAll()){
            resenas.add(resena);
        }
        return resenas;
    }

    public Resena getOne(Integer id) {
        return repo.findById(id).orElse(null);
    }

    public void add(Resena resena){
        Usuario usuario = usuarioService.getOne(resena.getUsuario().getId_usuario()); // Usa usuarioService para llamar a getOne
        Producto producto = productoService.getProductoById(resena.getProducto().getId_producto()); // Usa productoService para llamar a getOne
        resena.setUsuario(usuario); // Establece el Usuario en la Resena
        resena.setProducto(producto); // Establece el Producto en la Resena
        repo.save(resena);
    }

    public void eliminarResena(int id) {
        repo.deleteById(id);
    }

    public Resena actualizarResena(Integer id_resena, Resena resenaActualizada) {
        Optional<Resena> resenaExistente = repo.findById(id_resena);

        if (resenaExistente.isPresent()) {
            Resena resena = resenaExistente.get();
            Usuario usuario = usuarioService.getOne(resenaActualizada.getUsuario().getId_usuario()); // Usa usuarioService para llamar a getOne
            Producto producto = productoService.getProductoById(resenaActualizada.getProducto().getId_producto()); // Usa productoService para llamar a getOne
            resena.setUsuario(usuario); // Establece el Usuario en la Resena
            resena.setProducto(producto); // Establece el Producto en la Resena
            resena.setResena(resenaActualizada.getResena());
            resena.setCalificacion(resenaActualizada.getCalificacion());
            return repo.save(resena);
        } else {
            throw new NoSuchElementException("Reseña no encontrada");
        }
    }
}
