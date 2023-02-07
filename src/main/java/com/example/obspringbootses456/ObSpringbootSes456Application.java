package com.example.obspringbootses456;

import com.example.obspringbootses456.entity.Laptop;
import com.example.obspringbootses456.repository.LaptopRepository;
import org.aspectj.apache.bcel.Repository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ObSpringbootSes456Application {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(ObSpringbootSes456Application.class, args);
		LaptopRepository repository = context.getBean(LaptopRepository.class);

		Laptop laptop1 = new Laptop(null, "HP", "Envy", 8, true, "Core i5", 15);
		Laptop laptop2 = new Laptop(null, "Acer", "Nitro", 8, true, "Core i5", 15);
		Laptop laptop3 = new Laptop(null, "MSI", "GF63", 8, true, "Core i5", 15);
		repository.save(laptop1);
		repository.save(laptop2);
		repository.save(laptop3);

		System.out.println(repository.findAll().size());



	}

}
