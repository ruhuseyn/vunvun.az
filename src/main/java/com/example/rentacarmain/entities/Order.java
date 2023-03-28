package com.example.rentacarmain.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity(name = "order")
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Order {
    @Id
    @SequenceGenerator(
            name = "order_id_seq",
            sequenceName = "order_id_seq",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "order_id_seq")
    Long id;

    @Column(name = "price")
    Double price;

    @Column(name = "currency")
    String currency;//Dollar or Manat

    @Column(name = "payment_type")
    String paymentType;

    @ManyToOne
    @JoinColumn(name = "user_id")
    Users users;





}
