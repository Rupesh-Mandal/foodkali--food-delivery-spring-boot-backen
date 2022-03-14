package com.softkali.foodkali.order.model;

import com.softkali.foodkali.auth.model.AuthUser;
import com.softkali.foodkali.product.model.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddOrderModel {
    Product product;
    AuthUser authUser;

    private String deliverAddress;
    private String totalRate;
    private String productQuantity;
}
