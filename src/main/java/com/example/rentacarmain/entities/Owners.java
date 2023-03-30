package com.example.rentacarmain.entities;

import com.example.rentacarmain.entities.advertisement.Location;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity(name = "owners")
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
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

    @Column(name = "phone_number")
    String phoneNumber;

    @OneToOne
    @JoinColumn(name = "user_id")
    Users user;



}
