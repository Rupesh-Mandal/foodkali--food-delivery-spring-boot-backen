package com.softkali.foodkali.product.controller;


import com.softkali.foodkali.auth.model.AuthSeller;
import com.softkali.foodkali.auth.model.AuthUser;


import com.softkali.foodkali.product.model.AddProductModel;
import com.softkali.foodkali.product.model.Product;
import com.softkali.foodkali.product.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/product")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping(path = "add_product")
    public Object addProduct(@RequestBody AddProductModel addProductModel){
        return productService.addProduct(addProductModel);
    }

    @PostMapping(path = "update_product")
    public Object updateProduct(@RequestBody Product product){
        return productService.updateProduct(product);
    }

    @PostMapping(path = "get_all_product_seller")
    public Object getAllProoductSeller(@RequestBody AuthSeller authSeller){
        return productService.getAllProductSeller(authSeller);
    }

    @PostMapping(path = "delet_product")
    public Object deletProoduct(@RequestBody Product product){
        return productService.deletProduct(product);
    }


    @PostMapping(path = "get_all_product_user")
    public Object getAllProoductUser(@RequestBody AuthUser authUser){
        return productService.getAllProductUser(authUser);
    }

}
