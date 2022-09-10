package com.sadegh.data.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerContact extends Audit implements Serializable {

    private static final Long serialVersionUID=105l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ContactId;

    @Lob
    private String contactInfo;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;


    @OneToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

}
