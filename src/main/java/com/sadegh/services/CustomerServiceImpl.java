package com.sadegh.services;

import com.sadegh.data.CustomerDao;
import com.sadegh.data.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerDao customerDao;
    @Override
    @Transactional
    public void addCustomer(Customer customer) {

        customerDao.save(customer);



    }

    @Override
    public Customer findCustomerByUsername(String username) {
        return null;
    }

    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> customers= customerDao.findAll();
        return customers;
    }

    @Override
    public Customer getCustomerByCustomerId(long customerId) {
        return null;
    }

    @Override
    public Customer findCustomerByUsernameAndPassword(String username, String password) {
        return null;
    }
}
