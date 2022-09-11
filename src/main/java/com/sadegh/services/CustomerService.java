package com.sadegh.services;

import com.sadegh.data.entities.Customer;

import java.util.List;

public interface CustomerService {
    public void addCustomer(Customer customer);

    public Customer findCustomerByUsername(String username);

    List<Customer> getAllCustomers();

    public Customer getCustomerByCustomerId(long customerId);

    Customer findCustomerByUsernameAndPassword(String username,String password);



}
