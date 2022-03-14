package com.softkali.foodkali.product.service;

import com.softkali.foodkali.auth.model.AuthSeller;
import com.softkali.foodkali.auth.model.AuthUser;
import com.softkali.foodkali.auth.repository.SignUpSellerRepository;
import com.softkali.foodkali.product.model.AddProductModel;
import com.softkali.foodkali.product.model.Product;
import com.softkali.foodkali.product.repository.ProductRepository;
import lombok.AllArgsConstructor;
import net.minidev.json.JSONObject;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ProductService {
    private final SignUpSellerRepository signUpSellerRepository;
    private final ProductRepository productRepository;


    public Object addProduct(AddProductModel addProductModel) {
        JSONObject jsonObject = new JSONObject();

        boolean userExists = signUpSellerRepository.findByPhoneNumber(addProductModel.getAuthSeller().getPhoneNumber()).isPresent();
        if (userExists) {
            String productId= UUID.randomUUID().toString();

            Product product=new Product(productId,addProductModel.getAuthSeller().getSellerId(),addProductModel.getProductName(),addProductModel.getProductDescription(),
                    addProductModel.getProductRate(),addProductModel.getProductDeliverCharge(),addProductModel.getProductImageLink(),
                    addProductModel.getAuthSeller().getHotelname(),addProductModel.getAuthSeller().getEmail(),addProductModel.getAuthSeller().getPhoneNumber(),
                    LocalDateTime.now(),addProductModel.getProductType(),addProductModel.getAuthSeller().getLocation());

            productRepository.save(product);

            jsonObject.put("status", true);
            jsonObject.put("messag", "Successfully Uploaded");
            return jsonObject;
        }
        jsonObject.put("status", false);
        jsonObject.put("messag", "Sometinh Went Worng");
        return jsonObject;
    }


    public Object getAllProductSeller(AuthSeller authSeller) {
        List<Product> productList=productRepository.findByProductPhoneNumber(authSeller.getPhoneNumber()).get();
        return productList;
    }

    public Object deletProduct(Product product) {
        JSONObject jsonObject = new JSONObject();
        productRepository.delete(product);

        jsonObject.put("status", true);
        jsonObject.put("messag", "Successfully Deleted");
        return jsonObject;
    }

    public Object updateProduct(Product product) {
        JSONObject jsonObject = new JSONObject();
        productRepository.save(product);

        jsonObject.put("status", true);
        jsonObject.put("messag", "Successfully Deleted");
        return jsonObject;
    }

    public Object getAllProductUser(AuthUser authUser) {
        List<Product> productList=productRepository.findByLocation(authUser.getLocation()).get();
        return productList;
    }
}
