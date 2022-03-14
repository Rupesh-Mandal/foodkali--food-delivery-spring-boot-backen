package com.softkali.foodkali.product.model;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String productId;

    private String sellerId;

    private String productName;
    private String productDescription;
    private String productRate;
    private String productDeliverCharge;

    @Column(columnDefinition="TEXT")
    private String productImageLink;

    private String productHotelname;
    private String productEmail;
    private String productPhoneNumber;

    private LocalDateTime createdTime;
    private String productType;
    private String location;

    public Product(@NonNull String productId,String sellerId, String productName, String productDescription, String productRate, String productDeliverCharge, String productImageLink, String productHotelname, String productEmail, String productPhoneNumber, LocalDateTime createdTime, String productType, String location) {
        this.productId = productId;
        this.sellerId = sellerId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productRate = productRate;
        this.productDeliverCharge = productDeliverCharge;
        this.productImageLink = productImageLink;
        this.productHotelname = productHotelname;
        this.productEmail = productEmail;
        this.productPhoneNumber = productPhoneNumber;
        this.createdTime = createdTime;
        this.productType = productType;
        this.location = location;
    }
}
