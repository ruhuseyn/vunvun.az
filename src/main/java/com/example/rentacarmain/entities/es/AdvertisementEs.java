package com.example.rentacarmain.entities.es;

import com.example.rentacarmain.entities.Owners;
import com.example.rentacarmain.entities.advertisement.CarDetails;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.math.BigDecimal;


//@Entity(name = "advertisement")
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Document(indexName = "advertisement")
public class AdvertisementEs {

    //    @Id
    @Field(type = FieldType.Long)
    Long id;

    @Field(type = FieldType.Keyword)
    String title;

//    @Field(type = FieldType.Object)
//    CarDetails carDetails;
//
//    //    @Column(name = "discount")
//    @Field(type = FieldType.Double)
//    Double discount;

    //    @Column(name = "daily_payment")
    @Field(type = FieldType.Double)
    BigDecimal dailyPayment;

//    //    @Column(name = "additional_details")
//    @Field(type = FieldType.Text)
//    String additionalDetails;
//
//    //    @ManyToOne
////    @JoinColumn(name = "owner_id")
//    @Field
//    Owners owner;


}
