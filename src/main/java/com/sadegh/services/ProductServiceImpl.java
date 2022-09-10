package com.sadegh.services;

import com.sadegh.data.ProductDAO;
import com.sadegh.data.entities.Product;
import com.sadegh.models.ProductDTO;
import lombok.extern.log4j.Log4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
@Log4j
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductDAO productDAO;

    @Autowired
    ModelMapper mapper;

    @Override
    public void save(ProductDTO productDTO) {
        Product product=mapper.map(productDTO,Product.class);
        productDAO.save(product);
    }

    @Override
    public List<ProductDTO> findAll() {
       List<Product> products= productDAO.finAll();


        List<ProductDTO> productDTOList =
                products.stream().map(product -> mapper.map(product,ProductDTO.class)).collect(Collectors.toList());

        return productDTOList;
    }

    @Override
    public void delete(int id) {
        log.info("");
        productDAO.delete(id);
    }

}
