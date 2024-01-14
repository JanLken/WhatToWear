package com.webtech.whattowear.service;

import com.webtech.whattowear.model.Clothes;
import com.webtech.whattowear.repository.ClothesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<Clothes> getFilteredClothes(Long minTemp, Long maxTemp, String categories) {
        return clothesRepository.findAll().stream()
                .filter(clothes -> clothes.getMinTemp() <= maxTemp && clothes.getMaxTemp() >= minTemp && categories.contains(clothes.getCategory()))
                .collect(Collectors.toList());
    }
}
