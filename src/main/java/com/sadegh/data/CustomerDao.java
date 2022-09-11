package com.sadegh.data;

import com.sadegh.data.entities.Customer;

import java.util.List;

public interface CustomerDao {
    void save(Customer customer);

    Customer findUserByUsername(String username);

    List<Customer> findAll();

    Customer findOne(long customerId);

    Customer findCustomerByUsernameAndPassword(String username,String password);
}
