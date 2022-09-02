package com.muktai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.muktai.model.Product;
import com.muktai.service.IProductService;

@RestController
@RequestMapping("/product")
public class ProductRestController 
{
	@Autowired
	private IProductService service;
	
	@PostMapping("/save")
	public ResponseEntity<String> saveProduct(@RequestBody Product p)
	{
		int id=service.saveProduct(p);
		return ResponseEntity.ok("Product Created "+id);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Product>>getAllProducts()
	{
		List<Product>all=service.getAllProducts();
		return ResponseEntity.ok(all);
	}
	
	@GetMapping("/one/{id}")
	public ResponseEntity<Product> getOneProduct(@PathVariable int id)
	{
		Product p=service.getOneProduct(id);
		System.out.println("One Object returned");
		return ResponseEntity.ok(p);
	}
}
