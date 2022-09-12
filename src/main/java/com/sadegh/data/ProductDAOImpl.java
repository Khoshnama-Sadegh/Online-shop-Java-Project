package com.sadegh.data;

import com.sadegh.data.entities.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ProductDAOImpl implements ProductDAO{

    @Autowired
    SessionFactory sessionFactory;

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void save(Product product) {
        Session session=getSession();
        session.save(product);

        session.close();

    }

    @Override
    public List<Product> finAll() {
       try(Session session=getSession()){


           Query query= session.createQuery("from Product");

           List<Product> products=  query.list();

           return products;
       }
    }

    @Override
    public void delete(int id) {
        Session session=getSession();

//        Product p=new Product();
//        p.setId(id);

//        Product p=session.get(Product.class,id);
//
//        session.delete(p);

        Product p=session.get(Product.class,id);

        session.delete(p);

        session.close();


    }

    @Override
    public Product find(long productId) {

        Product product=entityManager.find(Product.class,productId);

        entityManager.close();

        return product;


    }


    public Session getSession(){
        return sessionFactory.openSession();

    }
}
