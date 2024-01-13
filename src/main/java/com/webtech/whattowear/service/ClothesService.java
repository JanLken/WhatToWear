package com.webtech.whattowear.service;

import com.webtech.whattowear.model.Clothes;
import com.webtech.whattowear.repository.ClothesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClothesService {

    @Autowired
    private ClothesRepository clothesRepository;

    public List<Clothes> getAll() {
        return clothesRepository.findAll();
    }

    public Optional<Clothes> getClothes(Long id) {
        return clothesRepository.findById(id);
    }

    public Clothes save(Clothes clothes) {
        return clothesRepository.save(clothes);
    }

    public void delete(Long id) {
        clothesRepository.deleteById(id);
    }

    public Clothes update(Long id, Clothes clothesDetails) {
        Clothes clothes = clothesRepository.findById(id).orElseThrow(() -> new RuntimeException("Clothes not found"));
        clothes.setCategory(clothesDetails.getCategory());
        clothes.setDescription(clothesDetails.getDescription());
        clothes.setMinTemp(clothesDetails.getMinTemp());
        clothes.setMaxTemp(clothesDetails.getMaxTemp());
        return clothesRepository.save(clothes);
    }
}
