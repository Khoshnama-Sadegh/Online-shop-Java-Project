package com.sadegh.data.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItem {

    private static final Long serialVersionUID=107l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartItemId;


    @ManyToOne
    @JoinColumn(name = "cartId")
    private Cart cart;


    @ManyToOne
    @JoinColumn(name ="productId")
    private Product product;





}
