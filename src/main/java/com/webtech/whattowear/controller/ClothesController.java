package com.webtech.whattowear.controller;

import com.webtech.whattowear.model.Clothes;
import com.webtech.whattowear.service.ClothesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clothes")
public class ClothesController {

    @Autowired
    private ClothesService clothesService;

    @GetMapping
    public List<Clothes> getAllClothes() {
        return clothesService.getAllClothes();
    }

    @GetMapping("/clothes/{id}")
    public ResponseEntity<Clothes> getClothesById(@PathVariable Long id) {
        Clothes clothes = clothesService.getClothesById(id)
                .orElseThrow(() -> new RuntimeException("Clothes not found"));
        return ResponseEntity.ok(clothes);
    }

    @PostMapping
    public Clothes createClothes(@RequestBody Clothes clothes) {
        return clothesService.saveClothes(clothes);
    }

    @PutMapping("/clothes/{id}")
    public ResponseEntity<Clothes> updateClothes(@PathVariable Long id, @RequestBody Clothes clothesDetails) {
        Clothes updatedClothes = clothesService.updateClothes(id, clothesDetails);
        return ResponseEntity.ok(updatedClothes);
    }

    @DeleteMapping("/clothes/{id}")
    public ResponseEntity<Void> deleteClothes(@PathVariable Long id) {
        clothesService.deleteClothes(id);
        return ResponseEntity.ok().build();
    }
}
