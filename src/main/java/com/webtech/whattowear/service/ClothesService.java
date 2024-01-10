package com.webtech.whattowear.service;

import com.webtech.whattowear.model.Clothes;
import com.webtech.whattowear.repository.ClothesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClothesService {

    @Autowired
    ClothesRepository repo;

    public Clothes save(Clothes clothes) {
        return repo.save(clothes);
    }

    public Clothes get(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException());
    }

    public List<Clothes> getAll() {
        Iterable<Clothes> iterator = repo.findAll();
        List<Clothes> clothes = new ArrayList<Clothes>();
        for (Clothes clothe : iterator)  clothes.add(clothe);
        return clothes;
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

}
