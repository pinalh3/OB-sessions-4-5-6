package com.example.obspringbootses456.entity;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Entity
@Table(name = "Laptops")
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String make;
    public String model;
    public Integer ram;
    public boolean videoCard;
    public String processor;
    public Integer monitor;

    public Laptop() {
    }

    public Laptop(Long id, String make, String model, Integer ram, boolean videoCard, String processor, Integer monitor) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.ram = ram;
        this.videoCard = videoCard;
        this.processor = processor;
        this.monitor = monitor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getRam() {
        return ram;
    }

    public void setRam(Integer ram) {
        this.ram = ram;
    }

    public boolean isVideoCard() {
        return videoCard;
    }

    public void setVideoCard(boolean videoCard) {
        this.videoCard = videoCard;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public Integer getMonitor() {
        return monitor;
    }

    public void setMonitor(Integer monitor) {
        this.monitor = monitor;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "id=" + id +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", ram=" + ram +
                ", videoCard=" + videoCard +
                ", processor='" + processor + '\'' +
                ", monitor=" + monitor +
                '}';
    }
}
