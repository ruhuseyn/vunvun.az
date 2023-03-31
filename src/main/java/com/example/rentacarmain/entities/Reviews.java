package com.example.rentacarmain.entities;

import com.example.rentacarmain.entities.advertisement.Advertisements;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.sql.Date;

@Entity(name = "reviews")
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Reviews {

    @Id
    @SequenceGenerator(
            name = "review_id_seq",
            sequenceName = "review_id_seq",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "review_id_seq")
    private Long id;

    @Column(name = "date")
    private Date date;

    @Column(name = "rate")
    private Double rate;

    @Column(name = "text")
    private String text;

    @ManyToOne
    @JoinColumn(name = "advertisement_id")
    Advertisements advertisements;

    @ManyToOne
    @JoinColumn(name = "user_id")
    Users user;

}
