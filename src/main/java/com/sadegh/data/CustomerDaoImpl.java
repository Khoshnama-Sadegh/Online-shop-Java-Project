package com.sadegh.data;

import com.sadegh.data.entities.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class CustomerDaoImpl implements CustomerDao{

    @Autowired
    SessionFactory sessionFactory;
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void save(Customer customer) {

//        entityManager.persist(customer);
//        entityManager.close();
        Session session=sessionFactory.openSession();

        session.save(customer);
        session.close();
    }

    @Override
    public Customer findUserByUsername(String username) {
        return null;
    }

    @Override
    public List<Customer> findAll() {
        return entityManager.createQuery("from Customer").getResultList();


    }

    @Override
    public Customer findOne(long customerId) {
        return null;
    }

    @Override
    public Customer findCustomerByUsernameAndPassword(String username, String password) {
        return null;
    }
}
