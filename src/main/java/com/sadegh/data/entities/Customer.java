package com.sadegh.data.entities;

import com.sadegh.validators.Phone;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends Audit implements Serializable {

    private static final Long serialVersionUID=102l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    @NotEmpty
    @Size(min = 5,max = 30)
    private String customerName;

    @NotEmpty
    @Email
    private String customerEmail;

    @NotEmpty
    @Phone
    private String customerPhoneNumber;

    @NotEmpty
    @Size(min = 3,max = 30)
    private String username;

    @NotEmpty
    private String password;

    private boolean enabled;


    //relations

    @OneToOne(mappedBy = "customer")
    private Cart cart;

    @Valid
    @OneToOne
    @JoinColumn(name = "shipingAddressId")
    private ShippingAddress shippingAddress;

    @Valid
    @OneToOne
    @JoinColumn(name = "billingAddressId")
    private BillingAddress billingAddress;



}
