package com.sadegh.controllers;

import com.sadegh.models.ProductDTO;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {



    List<ProductDTO> list=new ArrayList<ProductDTO>()
    {
        {
            add(new ProductDTO(102,"1",1000,"home"));
            add(new ProductDTO(21,"2",2000,"home"));
        }
    };

    Logger logger=Logger.getLogger(ProductController.class);

    @GetMapping("/show")
    public String showPage(@ModelAttribute("dto") ProductDTO productDTO){
        return "product-show";
    }

    @PostMapping("/save")
    public String save(ProductDTO productDTO){
        SecureRandom random=new SecureRandom();
        productDTO.setId(random.nextInt(1000));
        logger.debug(productDTO);
        list.add(productDTO);
        //TODO: must persist dto into database

        return "redirect:/";

    }

    @GetMapping(value = "/get-All")
    public String  getAll(Model model){

        model.addAttribute("products",list);

        return "product-list";

    }

    @GetMapping("/detail")
    public String detailWithQueryString(@RequestParam("id") int id){

        logger.debug(id);

        return "product-detail";

    }


    @GetMapping("/detail/{id}")
    public String detailWithPathVariable(@PathVariable("id") int id){
        logger.debug(id);

        //TODO:get the product and add it to model and then dispatch it to the view

        return "product-detail";
    }




}
