package com.softkali.foodkali.product.model;

import com.softkali.foodkali.auth.model.AuthSeller;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
@NoArgsConstructor
public class AddProductModel {


    private String productName;
    private String productDescription;
    private String productRate;
    private String productDeliverCharge;
    private String productImageLink;

    private AuthSeller authSeller;

    private String productType;

}
