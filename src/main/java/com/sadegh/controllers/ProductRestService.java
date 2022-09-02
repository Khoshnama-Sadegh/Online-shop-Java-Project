package com.sadegh.controllers;

import com.sadegh.models.ProductDTO;
import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product/rest")
public class ProductRestService {

    Logger logger=Logger.getLogger(ProductController.class);

    List<ProductDTO> list=new ArrayList<ProductDTO>()
    {
        {
//            add(new ProductDTO(102,"1",1000,"home"));
//            add(new ProductDTO(21,"2",2000,"home"));
        }
    };


    @GetMapping(value = "/detail/{id}",produces = MediaType.APPLICATION_JSON_VALUE)

    public ProductDTO detailWithPathParam(@PathVariable("id") int id){

        logger.debug(id);

        return list.get(0);
    }





}
