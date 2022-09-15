package com.sadegh.data;

import com.sadegh.data.entities.Cart;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CartDaoImpl implements CartDao{

    @PersistenceContext
    EntityManager entityManager;


    @Override
    public Cart findUserByCartId(long cartId) {
        return null;
    }

    @Override
    public void save(Cart cart) {
        entityManager.persist(cart);
        entityManager.close();

    }

    @Override
    public List<Cart> findAll() {
        return null;
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public Cart find(long id) {
        return null;
    }
}
