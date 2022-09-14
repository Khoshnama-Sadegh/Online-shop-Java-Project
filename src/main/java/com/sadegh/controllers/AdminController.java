package com.sadegh.controllers;

import com.sadegh.data.entities.Product;
import com.sadegh.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    ProductService productService;

    @RequestMapping
    public String adminPage(){
        return "admin";
    }

    @RequestMapping("/productManagement/{pageNumber}")
    public String productManagement(@PathVariable Integer pageNumber, Model model){

        List<Product> products=productService.findAll();

        model.addAttribute("product",products);

        return "productInventory";

    }




    @RequestMapping("/productManagement/search/{pageNumber}")
    public String productManagement(@PathVariable Integer pageNumber,
                                    Model model, @RequestParam("searchTerm")String searchTerm){

        List<Product> products=productService.getAllProductsByBrandOrModelOrCategory(searchTerm);

        model.addAttribute("products",products);

        return "productInventory";




    }



    }
