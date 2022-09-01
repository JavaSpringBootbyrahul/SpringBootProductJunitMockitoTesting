package com.muktai.service;

import java.util.List;

import com.muktai.model.Product;

public interface IProductService {
	public int saveProduct(Product p);
	public List<Product>getAllProducts();
	public Product getOneProduct(int id);
}
