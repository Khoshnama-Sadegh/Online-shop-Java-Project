package com.sadegh.services;

import com.sadegh.data.entities.Cart;

public interface CartService {
    void addCart(Cart cart);

    Cart getCartById(long id);

    Cart validateCustomer(long cartId);
}
