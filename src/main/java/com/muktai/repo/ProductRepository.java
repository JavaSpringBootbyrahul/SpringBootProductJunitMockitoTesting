package com.muktai.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.muktai.model.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

}
