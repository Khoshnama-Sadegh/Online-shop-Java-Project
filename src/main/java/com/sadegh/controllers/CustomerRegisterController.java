package com.sadegh.controllers;

import com.sadegh.data.entities.*;
import com.sadegh.services.AuthoritiesService;
import com.sadegh.services.CartService;
import com.sadegh.services.CustomerService;
import com.sadegh.services.UsersService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/dummy")
@AllArgsConstructor
@Data
public class CustomerRegisterController {

    private CustomerService customerService;
    private UsersService usersService;
    private AuthoritiesService authoritiesService;
    private CartService cartService;

    @GetMapping("/register")
    public String registerCustomer(@ModelAttribute("customer") Customer customer){

        customer.setCustomerName("dummy");
        customer.setCustomerEmail("a@a.com");
        customer.setCustomerPhoneNumber("09121111111");

        return "registerCustomer";

    }



    @PostMapping("/register")
    public String save(@Valid @ModelAttribute("customer") Customer customer, BindingResult result,Model model,HttpServletRequest request){

       if(result.hasErrors()){
           return "registerCustomer";
       }

        List<Customer> customers=customerService.getAllCustomers();

       if(customers==null){
           customers=new ArrayList<>();
       }


       for(Customer customer2: customers){

           if(customer2.getCustomerEmail().equals(customer.getCustomerEmail())){
               model.addAttribute("emailMsg","Email already exists");
               return "registerCustomer";
           }


           if(customer2.getUsername().equals(customer.getUsername())){
               model.addAttribute("usernameMsg","Username already exists");
               return "registerCustomer";
           }
       }


       customer.setEnabled(true);

       customerService.addCustomer(customer);

        //TODO: create user based on customer data
        Users users=new Users();

        users.setCustomerId(customer.getCustomerId());

        users.setEnabled(true);
        users.setPassword(customer.getPassword());
        users.setUsername(customer.getUsername());

        //TODO: persist user to database which is connected to the customer
        usersService.addUser(users);


        //TODO: SET Authority as a ROLE_USER and update authority table

        Authorities authorities=new Authorities();
        authorities.setAuthorityType("ROLE_USER");
        authorities.setUsername(customer.getUsername());

        authoritiesService.addAuthorities(authorities);


        Cart cart=new Cart();

        cart.setCustomer(customer);
        cart.setGrandTotal(0.0);

        cartService.addCart(cart);

        customer.setCart(cart);

        autoLogin(customer,request);




        return "registerCustomerSuccess";
    }



    private void autoLogin(Customer customer, HttpServletRequest request) {

        String username=customer.getUsername();
        String password=customer.getPassword();



        // generate session if one doesn't exist
        request.getSession();


        Authentication authentication=new UsernamePasswordAuthenticationToken(username, password);
        SecurityContextHolder.getContext().setAuthentication(authentication);


    }


}
