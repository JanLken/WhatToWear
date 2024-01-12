package com.webtech.whattowear.controller;

import com.webtech.whattowear.repository.ClothesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.webtech.whattowear.model.Clothes;
import com.webtech.whattowear.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
//@CrossOrigin("http://localhost:3000")
public class ClothesController {

    @Autowired
    ClothesService service;

    @Autowired
    private ClothesRepository clothesRepository;

    Logger logger = LoggerFactory.getLogger(ClothesController.class);

    @PostMapping("/clothes")
    public Clothes createClothes(@RequestBody Clothes clothes) {
        return service.save(clothes);
    }

    @GetMapping("/clothes/{id}")
    public Clothes getClothes(@PathVariable String id) {
        logger.info("GET request on route things with {}", id);
        Long clothesId = Long.parseLong(id);
        return service.get(clothesId);
    }
    @DeleteMapping("/clothes/{id}")
    public Clothes deleteClothes(@PathVariable Long id) {
        service.delete(id);
        return new Clothes(); // Using HttpStatus.OK directly
    }

    @GetMapping("/clothes")
    public List<Clothes> getAllClothes() {
        return service.getAll();
    }

    @PutMapping("/clothes/{id}")
    public Clothes updateClothes(@PathVariable Long id, @RequestBody Clothes clothesDetails) {
        Clothes clothes = clothesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Clothes not found"));

        clothes.setCategory(clothesDetails.getCategory());
        clothes.setDescription(clothesDetails.getDescription());
        clothes.setMinTemp(clothesDetails.getMinTemp());
        clothes.setMaxTemp(clothesDetails.getMaxTemp());


        return clothesRepository.save(clothes);
    }
}



