package com.softkali.foodkali.order.controller;

import com.softkali.foodkali.auth.model.AuthSeller;
import com.softkali.foodkali.auth.model.AuthUser;
import com.softkali.foodkali.order.model.AddOrderModel;
import com.softkali.foodkali.order.model.OrderModel;
import com.softkali.foodkali.order.service.OrderService;
import com.softkali.foodkali.product.model.Product;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/order")
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping(path = "add")
    public Object oderProduct(@RequestBody AddOrderModel addOrderModel){
        return orderService.add(addOrderModel);
    }

    @PostMapping(path = "get_order_as_usser")
    public Object getProductUser(@RequestBody AuthUser authUser){
        return orderService.getOrderAsUser(authUser);
    }

    @PostMapping(path = "get_order_as_seller")
    public Object getProductSeller(@RequestBody AuthSeller authSeller){
        return orderService.getOrderAsSeller(authSeller);
    }

    @PostMapping(path = "accept_order")
    public Object acceptOrder(@RequestBody OrderModel orderModel){
        return orderService.acceptOrder(orderModel);
    }


    @PostMapping(path = "delivered_order")
    public Object deleveredOrder(@RequestBody OrderModel orderModel){
        return orderService.deleveredOrder(orderModel);
    }


    @PostMapping(path = "faild_to_delivered_order")
    public Object faildToDeliveredOrder(@RequestBody OrderModel orderModel){
        return orderService.faildToDeliveredOrder(orderModel);
    }


    @PostMapping(path = "cancel_order_by_seller")
    public Object cancelOrderBySeller(@RequestBody OrderModel orderModel){
        return orderService.cancelOrderBySeller(orderModel);
    }


}
