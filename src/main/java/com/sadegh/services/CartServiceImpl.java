package com.sadegh.services;

import com.sadegh.data.CartDao;
import com.sadegh.data.entities.Cart;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CartServiceImpl implements CartService {

    CartDao cartDao;

    @Override
    public void addCart(Cart cart) {

        cartDao.save(cart);
    }

    @Override
    public Cart getCartById(long id) {
        return null;
    }

    @Override
    public Cart validateCustomer(long cartId) {
        return null;
    }
}
