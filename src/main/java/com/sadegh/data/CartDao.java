package com.sadegh.data;

import com.sadegh.data.entities.Cart;

import java.util.List;

public interface CartDao {
    Cart findUserByCartId(long cartId);

    void save(Cart cart);

    List<Cart> findAll();

    void delete(long id);

    Cart find(long id);

}
