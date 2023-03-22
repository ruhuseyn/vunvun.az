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


@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Document(indexName = "advertisement")
public class AdvertisementEs {

    @Id
    Long id;

    @Field(type = FieldType.Keyword)
    String title;

   @Field(type = FieldType.Long)
   Long brandId;

   @Field(type = FieldType.Long)
   Long modelId;

    @Field(type = FieldType.Integer)
    Integer price;


}
