package com.example.rentacarmain.entities.elasticsearch;

import com.example.rentacarmain.entities.car.CarList;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.mapping.Join;
import org.springframework.data.elasticsearch.annotations.Document;

@Entity(name = "elastic_search")
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Document(indexName = "elasticsearch")
public class ElasticSearch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @OneToOne
    @JoinColumn(name = "carlist_id")
    CarList carList;
}
