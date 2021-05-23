package com.javatechie.spring.docker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
public class SpringbootDockerApplication {

	@Autowired
	private ProductRepository repository;

	@GetMapping("/message/{username}")
	public String sayWelcomeToUser(@PathVariable String username){
		return "Hi "+username+" welcome to javatechie";
	}

	@PostMapping("/product")
	public Product save(@RequestBody Product product){
		return repository.save(product);
	}

	@GetMapping("/products")
	public List<Product> getProducts(){
		return repository.findAll();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDockerApplication.class, args);
	}

}
