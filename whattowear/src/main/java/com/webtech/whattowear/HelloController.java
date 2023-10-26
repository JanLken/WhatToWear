package com.webtech.whattowear;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

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



}
