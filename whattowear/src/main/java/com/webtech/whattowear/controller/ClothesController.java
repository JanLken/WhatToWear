package com.webtech.whattowear.controller;

import com.webtech.whattowear.model.Clothes;
import com.webtech.whattowear.repository.ClothesRepository;
import com.webtech.whattowear.service.ClothesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clothes")
public class ClothesController {

    private final ClothesRepository repository;

    @Autowired
    ClothesService service;

    @PostMapping("/clothes")
    public Clothes createClothes(@RequestBody Clothes clothes){
        return service.save(clothes);
    }

    @GetMapping("/clothes/{id}")
    public Clothes getClothes(@PathVariable Integer id) {
        return service.get(id);
    }

    public ClothesController(ClothesRepository repository){
        this.repository = repository;
    }
    @GetMapping
    public Iterable<Clothes> findAll() {
        return repository.findAll();
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


}
