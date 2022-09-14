package com.sadegh.services;

import com.sadegh.data.entities.Product;
import com.sadegh.models.ProductDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {

    void save(Product product);


    List<Product> findAll();

    void delete(int id);

    Product find(long productId);

    List<Product> getAllProductsByBrandOrModelOrCategory(String searchTerm);
}
