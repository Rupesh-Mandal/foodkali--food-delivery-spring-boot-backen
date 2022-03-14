package com.softkali.foodkali.order.model;

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
public class OrderModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String orderId;

    private String deliverAddress;
    private String totalRate;
    private String productQuantity;

    private String productId;
    private String userId;
    private String sellerId;



    private String productName;
    private String productDescription;
    private String productRate;
    private String productDeliverCharge;
    private String productImageLink;
    private String productHotelname;
    private String productEmail;
    private String productPhoneNumber;
    private String userPhoneNumber;
    private String userName;


    private String status;
    private String statusMessage;

    private LocalDateTime createdTime;
    private String location;

    public OrderModel(@NonNull String orderId, String deliverAddress, String totalRate, String productQuantity, String productId, String userId, String sellerId, String productName, String productDescription, String productRate, String productDeliverCharge, String productImageLink, String productHotelname, String productEmail, String productPhoneNumber, String userPhoneNumber, String userName, String status, String statusMessage, LocalDateTime createdTime, String location) {
        this.orderId = orderId;
        this.deliverAddress = deliverAddress;
        this.totalRate = totalRate;
        this.productQuantity = productQuantity;
        this.productId = productId;
        this.userId = userId;
        this.sellerId = sellerId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productRate = productRate;
        this.productDeliverCharge = productDeliverCharge;
        this.productImageLink = productImageLink;
        this.productHotelname = productHotelname;
        this.productEmail = productEmail;
        this.productPhoneNumber = productPhoneNumber;
        this.userPhoneNumber = userPhoneNumber;
        this.userName = userName;
        this.status = status;
        this.statusMessage = statusMessage;
        this.createdTime = createdTime;
        this.location = location;
    }
}
