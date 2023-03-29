package com.example.rentacarmain.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity(name = "owners")
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Owners {

    @Id
    @SequenceGenerator(
            name = "owner_id_seq",
            sequenceName = "owner_id_seq",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "owner_id_seq")
    Long id;

//    @Column(name = "image")
//    Byte[] hostImage;

    @Column(name = "phone_number")
    String phoneNumber;

    @OneToOne
    @JoinColumn(name = "user_id")
    Users user;



}
