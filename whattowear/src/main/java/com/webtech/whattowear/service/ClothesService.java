package com.webtech.whattowear.service;

import com.webtech.whattowear.model.Clothes;
import com.webtech.whattowear.repository.ClothesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClothesService {

    @Autowired
    ClothesRepository clothesRepository;

    public Clothes save(Clothes clothes) {
        return clothesRepository.save(clothes);
    }

    public Clothes get(Integer id) {
        return clothesRepository.findById(id).orElseThrow(() -> new RuntimeException());
    }
}
