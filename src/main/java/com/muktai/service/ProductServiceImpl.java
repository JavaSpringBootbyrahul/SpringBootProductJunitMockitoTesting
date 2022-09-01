package com.muktai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.muktai.excHandler.ProductNotFoundException;
import com.muktai.model.Product;
import com.muktai.repo.ProductRepository;
@Service
public class ProductServiceImpl implements IProductService{

	@Autowired
	private ProductRepository repo;
	@Override
	public int saveProduct(Product p) {
		Product p1=repo.save(p);
		return p1.getId();
	}
	@Override
	public List<Product> getAllProducts() {
		return repo.findAll();
	}
	@Override
	public Product getOneProduct(int id) 
	{
		Optional<Product>op=repo.findById(id);
		if(op.isEmpty())
			throw new ProductNotFoundException("requested Product Not Found");
		return op.get();
	}

}
