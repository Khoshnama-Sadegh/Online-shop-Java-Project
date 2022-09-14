package com.sadegh.controllers;

import com.sadegh.data.entities.Product;
import com.sadegh.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

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



    @GetMapping(value = "/product/getImage/{productId}",produces = "image/png")
    @ResponseBody
    public byte[] getProductImage(@PathVariable("productId") long productId){

        Product product = productService.find(productId);

        return product.getImg();

    }





}
