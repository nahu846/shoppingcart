package org.example.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Table(name = "order_items")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
//    @Column(name = "id_user")
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    private User user;
//    @Column(name = "id_product")
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_product")
    private Product product;
    private int quantity;
    @Column(name = "total_amount")
    private int totalAmount;
//    @Setter(AccessLevel.NONE)
    @Column(name = "creation_date")
    private Date creationDate = new Date();
    private String state;

}
