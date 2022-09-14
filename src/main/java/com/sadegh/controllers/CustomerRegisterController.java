package com.sadegh.controllers;

import com.sadegh.data.entities.BillingAddress;
import com.sadegh.data.entities.Customer;
import com.sadegh.data.entities.ShippingAddress;
import com.sadegh.services.CustomerService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
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
@AllArgsConstructor
@Data
public class CustomerRegisterController {

    private CustomerService customerService;

    @GetMapping("/register")
    public String registerCustomer(@ModelAttribute("customer") Customer customer){

        return "registerCustomer";

    }



    @PostMapping("/register")
    public String save(@Valid @ModelAttribute("customer") Customer customer, BindingResult result){

       if(result.hasErrors()){
           return "registerCustomer";
       }

       customerService.addCustomer(customer);

       //TODO: create user based on customer data

        //TODO: SET Authority as a ROLE_USER and update authority table

       //TODO: persist user to database which is connected to the customer

        return "registerCustomerSuccess";
    }


}
