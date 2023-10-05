package com.example.modeladov1.service;


import java.util.ArrayList;
import java.util.List;
import com.example.modeladov1.model.Categoria;
import com.example.modeladov1.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {
    @Autowired
    CategoriaRepository repo;

    public List<Categoria> getAll(){
        List<Categoria> categorias = new ArrayList<>();
        for(Categoria categoria : repo.findAll()){
            categorias.add(categoria);
        }
        return categorias;
    }

    public Categoria getOne(Integer id) {
      return repo.findById(id).orElse(null);
    }

    public void add(Categoria categoria){
        repo.save(categoria);
    }
    public void eliminarCategoria(int id) {
        repo.deleteById(id);
    }
}