package com.sadegh.controllers;

import com.sadegh.data.entities.BillingAddress;
import com.sadegh.data.entities.Customer;
import com.sadegh.data.entities.ShippingAddress;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/customer")
public class CustomerRegisterController {

    @GetMapping("/register")
    public String registerCustomer(@ModelAttribute("customer") Customer customer){

        return "registerCustomer";

    }



    @PostMapping("/register")
    public String save(@Valid @ModelAttribute("customer") Customer customer, BindingResult result){

       if(result.hasErrors()){
           return "registerCustomer";
       }






        return "";
    }


}
