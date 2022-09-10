package com.sadegh.data;

import com.sadegh.data.entities.Product;
import com.sadegh.models.ProductDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ProductDAO {
    void save(Product product);

    List<Product> finAll();

    void delete(int id);
}
