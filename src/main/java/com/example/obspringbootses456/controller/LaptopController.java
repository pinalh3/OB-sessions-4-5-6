package com.example.obspringbootses456.controller;

import com.example.obspringbootses456.entity.Laptop;
import com.example.obspringbootses456.repository.LaptopRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    @GetMapping("/api/laptop/{id}")
    public ResponseEntity<Laptop> findOneBy(@PathVariable Long id){

        Optional<Laptop> laptopOpt = laptopRepository.findById(id);
        if(laptopOpt.isPresent()){
            return ResponseEntity.ok(laptopOpt.get());
        }else {
            return ResponseEntity.notFound().build();
        }

    }
    @PostMapping("/api/laptop")
    public ResponseEntity<Laptop> create(@RequestBody Laptop laptop){
        if(laptop.getId() !=null){
            return ResponseEntity.badRequest().build();
        }
        System.out.println("Laptop creada");
        Laptop result = laptopRepository.save(laptop);
        return ResponseEntity.ok(result);
    }
    @PutMapping("/api/laptop")
    public ResponseEntity<Laptop> update(@RequestBody Laptop laptop){
        if(laptop.getId() == null){
            System.out.println("intentando actualizar una Laptop que no existe");
        }
        if(!laptopRepository.existsById(laptop.getId())){
            return ResponseEntity.notFound().build();
        }
        System.out.println("Actualizado laptop");
        Laptop result = laptopRepository.save(laptop);
        return ResponseEntity.ok(result);

    }
    @DeleteMapping("/api/laptop/{id}")
    public ResponseEntity<Laptop> delete(@PathVariable Long id){
        if(!laptopRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        System.out.println("Delete by Id");
        laptopRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/api/laptop")
    public ResponseEntity<Laptop> deleteAll(){
        System.out.println("Delete All");
        laptopRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }


}
