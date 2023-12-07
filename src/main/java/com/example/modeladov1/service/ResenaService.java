package com.example.modeladov1.service;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import com.example.modeladov1.model.EstadoPedido;
import com.example.modeladov1.model.Resena;
import com.example.modeladov1.repository.ResenaRepository;
import com.example.modeladov1.model.Producto;
import com.example.modeladov1.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ResenaService {
    @Autowired
    ResenaRepository repo;

    @Autowired
    UsuarioService usuarioService; // Inyecta usuarioService

    @Autowired
    ProductoService productoService; // Inyecta productoService

    public ResponseEntity<List<Resena>> getAll(){
        List<Resena> resenas = new ArrayList<>();
        for(Resena resena : repo.findAll()){
            resenas.add(resena);
        }
        return new ResponseEntity<>(resenas, HttpStatus.OK);
    }

    public ResponseEntity<Resena> getOne(Integer id) {
        Resena objeto = repo.findById(id).orElse(null);
        if(objeto!=null){
            return new ResponseEntity<>(objeto, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    public ResponseEntity<Resena> add(Resena resena){
        Resena objeto = repo.save(resena);
        return new ResponseEntity<>(objeto, HttpStatus.OK);
    }

    public ResponseEntity<Resena> eliminarResena(int id) {
        if(repo.findById(id).isPresent()){
            repo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    public ResponseEntity<Resena> actualizarResena(Integer id_resena, Resena resenaActualizada) {
        Optional<Resena> resenaExistente = repo.findById(id_resena);

        if (resenaExistente.isPresent()) {
            Resena resena = resenaExistente.get();
            resena.setResena(resenaActualizada.getResena());
            resena.setCalificacion(resenaActualizada.getCalificacion());
            Resena objeto = repo.save(resena);
            return new ResponseEntity<>(objeto,HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
