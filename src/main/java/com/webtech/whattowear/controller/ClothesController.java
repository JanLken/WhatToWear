package com.webtech.whattowear.controller;

import com.webtech.whattowear.repository.ClothesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.webtech.whattowear.model.Clothes;
import com.webtech.whattowear.service.ClothesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class ClothesController {
/*
    @Autowired
    private ClothesRepository clothesRepository;

    @GetMapping("/clothes")
    public List<Clothes> fetchClothes(){
    return (List<Clothes>) clothesRepository.findAll();
    }
}

*/



    @Autowired
    ClothesService service;

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

    @GetMapping("/clothes")
    public List<Clothes> getAllClothes() {
        return service.getAll();
    }

}


    /*
   @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/user/{userid}")
    public String userid(@PathVariable int userid) {
        return "Hello World " + userid;
    }

    @GetMapping("/user/{userid}/password/{password}")
    public String useridupassword(@PathVariable int userid, @PathVariable String password) {
        return "UserID: " + userid + " Password: " + password;
    }

    @GetMapping("/user")
    public String queryparam(@RequestParam int userid, @RequestParam(required = false) String password) {
        return "UserID: " + userid + " Password: " + password;
    }
*/



