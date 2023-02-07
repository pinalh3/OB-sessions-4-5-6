package com.example.obspringbootses456.controller;

import com.example.obspringbootses456.entity.Laptop;
import com.example.obspringbootses456.repository.LaptopRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LaptopController {
    private LaptopRepository laptopRepository;

    public LaptopController(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    @GetMapping("/api/laptop")
    public List<Laptop> findAll(){
        return laptopRepository.findAll();
    }


}
