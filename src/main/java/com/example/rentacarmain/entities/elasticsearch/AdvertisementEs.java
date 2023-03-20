package com.example.rentacarmain.entities.elasticsearch;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Document(indexName = "elasticsearch")
public class AdvertisementEs {

    @Id
    Long id;

    @Field(type = FieldType.Keyword)
    String title;

    @Field(type = FieldType.Text)
    String description;

    @Field(type = FieldType.Integer)
    Integer price;


}
