package com.webtech.whattowear.controller;

import com.webtech.whattowear.model.Clothes;
import com.webtech.whattowear.repository.ClothesRepository;
import com.webtech.whattowear.service.ClothesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clothes")
@CrossOrigin("http://localhost:3000")
public class ClothesController {

    @Autowired
    private ClothesService clothesService;

    @Autowired
    private ClothesRepository clothesRepository;

    @GetMapping
    public List<Clothes> getAllClothes() {
        return clothesService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Clothes> getClothesById(@PathVariable Long id) {
        Clothes clothes = clothesService.getClothes(id)
                .orElseThrow(() -> new RuntimeException("Clothes not found"));
        return ResponseEntity.ok(clothes);
    }

    @PostMapping
    public Clothes createClothes(@RequestBody Clothes clothes) {
        return clothesService.save(clothes);
    }
    @PutMapping("/{id}")
    public Clothes updateClothes(@PathVariable Long id, @RequestBody Clothes clothesDetails) {
        Clothes clothes = clothesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Clothes not found"));

        clothes.setCategory(clothesDetails.getCategory());
        clothes.setDescription(clothesDetails.getDescription());
        clothes.setMinTemp(clothesDetails.getMinTemp());
        clothes.setMaxTemp(clothesDetails.getMaxTemp());


        return clothesRepository.save(clothes);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClothes(@PathVariable Long id) {
        clothesService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/filter")
    public ResponseEntity<List<Clothes>> getFilteredClothes(@RequestParam("minTemp") Long minTemp, @RequestParam("maxTemp") Long maxTemp, @RequestParam("categories") String categories) {
        List<Clothes> filteredClothes = clothesService.getFilteredClothes(minTemp, maxTemp, categories);
        return ResponseEntity.ok(filteredClothes);
    }

}