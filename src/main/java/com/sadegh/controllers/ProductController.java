package com.sadegh.controllers;

import com.sadegh.models.ProductDTO;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {

    Logger logger=Logger.getLogger(ProductController.class);

    @GetMapping("/show")
    public String showPage(){
        return "product-show";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute ProductDTO productDTO){

        logger.debug(productDTO);
        return "index";

    }
}
