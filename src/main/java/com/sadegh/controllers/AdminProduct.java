package com.sadegh.controllers;

import com.sadegh.data.entities.Product;
import com.sadegh.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.io.IOException;

@Controller
@RequestMapping("/admin")
public class AdminProduct {

    @Autowired
    ProductService productService;

    @GetMapping("/product/addProduct")
    public String showProductPage(@ModelAttribute("product")Product product){

        return "addProduct";
    }


    @PostMapping("/product/addProduct")
    public String addProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) throws IOException {
        if(result.hasErrors()){
            return "addProduct";
        }

        byte[] imgByte=product.getProductImage().getBytes();
        product.setImg(imgByte);

        productService.save(product);



        return "redirect:/admin/productManagement/1";
    }
}
