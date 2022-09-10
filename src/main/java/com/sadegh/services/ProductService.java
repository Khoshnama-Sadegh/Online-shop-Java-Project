package com.sadegh.services;

import com.sadegh.models.ProductDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {

    void save(ProductDTO productDTO);


    List<ProductDTO> findAll();

    void delete(int id);
}
