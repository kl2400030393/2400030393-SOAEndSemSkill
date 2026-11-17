package com.example.controllertestingdemo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    Map<Integer, String> users = new HashMap<>();

    @GetMapping("/add")
    public int add(@RequestParam int a, @RequestParam int b) {
        return a + b;
    }

    @GetMapping("/subtract")
    public int subtract(@RequestParam int a, @RequestParam int b) {
        return a - b;
    }

    @GetMapping("/multiply")
    public int multiply(@RequestParam int a, @RequestParam int b) {
        return a * b;
    }

    @GetMapping("/divide")
    public int divide(@RequestParam int a, @RequestParam int b) {
        return a / b;
    }

    @PostMapping("/users")
    public String addUser(@RequestParam int id,
                          @RequestParam String name) {
        users.put(id, name);
        return "User Added Successfully";
    }

    @GetMapping("/users")
    public Map<Integer, String> getUsers() {
        return users;
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable int id) {
        users.remove(id);
        return "User Deleted Successfully";
    }
}