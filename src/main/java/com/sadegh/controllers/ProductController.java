package com.sadegh.controllers;

import com.sadegh.models.ProductDTO;
import com.sadegh.services.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/product")
@Log4j
@AllArgsConstructor
public class ProductController {

    ProductService productService;




    @GetMapping("/show")
    public String showPage(@ModelAttribute("dto") ProductDTO.CREATE productDTO){
        return "product-show";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("dto") @Valid ProductDTO productDTO, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "product-show";
        }

        productService.save(productDTO);

        return "redirect:/";

    }

    @GetMapping(value = "/get-All")
    public String  getAll(Model model){
        List<ProductDTO> productDTOList=productService.findAll();

        model.addAttribute("products",productDTOList);

        return "product-list";

    }

    @GetMapping("/detail")
    public String detailWithQueryString(@RequestParam("id") int id){

        log.debug(id);

        return "product-detail";

    }


    @GetMapping("/detail/{id}")
    public String detailWithPathVariable(@PathVariable("id") int id){
        log.debug(id);

        //TODO:get the product and add it to model and then dispatch it to the view

        return "product-detail";
    }


    @GetMapping("/delete")
    public String delete(@RequestParam("id") int id){


        productService.delete(id);

        return "redirect:/product/get-All";
    }




}
