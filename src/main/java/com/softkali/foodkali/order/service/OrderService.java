package com.softkali.foodkali.order.service;

import com.softkali.foodkali.auth.model.AuthSeller;
import com.softkali.foodkali.auth.model.AuthUser;
import com.softkali.foodkali.order.model.AddOrderModel;
import com.softkali.foodkali.order.model.OrderModel;

import com.softkali.foodkali.order.repository.OrderRepository;
import com.softkali.foodkali.product.model.Product;
import lombok.AllArgsConstructor;
import net.minidev.json.JSONObject;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.*;

@Service
@AllArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final String serverKey="key=AAAAMv27dXQ:APA91bG-yTg2kMnSjyub49--SVrjU1TTS_CvRaK1E9JWxN3y50GvWB3HPIUAtbA0hsf-kKyV06OcOrnxmyTmhpfsAkoyV2gVjurqUKMxvyXL8LtpxCKDSEuxLxNSAd0mgdj7IRDxcrNM";


    public Object add(AddOrderModel addOrderModel) {
        String status="1";
        String statusMassege="Pending to start";

        Product product=addOrderModel.getProduct();
        AuthUser authUser=addOrderModel.getAuthUser();

        JSONObject jsonObject=new JSONObject();
        String orderId= UUID.randomUUID().toString();

        OrderModel orderModel=new OrderModel(orderId,addOrderModel.getDeliverAddress(),addOrderModel.getTotalRate(),addOrderModel.getProductQuantity(),
                product.getProductId(),authUser.getUserId(),product.getSellerId(),product.getProductName(),
                product.getProductDescription(),product.getProductRate(),product.getProductDeliverCharge(),product.getProductImageLink(),
                product.getProductHotelname(),product.getProductEmail(),product.getProductPhoneNumber(),authUser.getPhoneNumber(),authUser.getName(),
                status,statusMassege,LocalDateTime.now(),product.getLocation());

        Long id =orderRepository.save(orderModel).getId();
        if (id!=null){
            jsonObject.put("status", true);
            jsonObject.put("messag", "Successfully Ordered");


            sendNotification(addOrderModel.getProduct().getProductName(),
                    addOrderModel.getProduct().getProductDescription(),
                    "/topics/"+addOrderModel.getProduct().getSellerId());

            return jsonObject;

        }

        jsonObject.put("status", false);
        jsonObject.put("messag", "something went wrong");
        return jsonObject;
    }





    @Async
    void sendNotification(String title, String body, String to) {
        JSONObject jsonObject = new JSONObject();
        JSONObject dataObject = new JSONObject();
        dataObject.put("title",title);
        dataObject.put("body",body);
        jsonObject.put("to",to);

        jsonObject.put("data",dataObject);

        String url = "https://fcm.googleapis.com/fcm/send";

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.add("Authorization",serverKey);

// build the request
        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(jsonObject, headers);

// send POST request
        ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class);
        System.out.println(response.toString());
    }

    public Object getOrderAsUser(AuthUser authUser) {
        List<OrderModel> orderModelList=orderRepository.findByUserId(authUser.getUserId()).get();
        Collections.sort(orderModelList, new Comparator<OrderModel>() {
            @Override
            public int compare(OrderModel u1, OrderModel u2) {
                return u2.getId().compareTo(u1.getId());
            }
        });

        return orderModelList;
    }

    public Object getOrderAsSeller(AuthSeller authSeller) {
        List<OrderModel> orderModelList=orderRepository.findBySellerId(authSeller.getSellerId()).get();
        Collections.sort(orderModelList, new Comparator<OrderModel>() {
            @Override
            public int compare(OrderModel u1, OrderModel u2) {
                return u2.getId().compareTo(u1.getId());
            }
        });

        return orderModelList;
    }

    public Object acceptOrder(OrderModel orderModel) {
        JSONObject jsonObject=new JSONObject();

        orderModel.setStatus("2");
        orderModel.setStatusMessage("Order started to deliver");
        orderRepository.save(orderModel);
        if (orderRepository.save(orderModel).getStatus().equals("2")){
            jsonObject.put("status", true);
            jsonObject.put("messag", "Order started to deliver");
            sendNotification("Order Started",orderModel.getProductName(),"/topics/"+orderModel.getUserId());
            return jsonObject;
        }

        jsonObject.put("status", false);
        jsonObject.put("messag", "something went wrong");
        return jsonObject;
    }

    public Object deleveredOrder(OrderModel orderModel) {
        JSONObject jsonObject=new JSONObject();

        orderModel.setStatus("3");
        orderModel.setStatusMessage("Successfully Delivered");
        orderRepository.save(orderModel);
        if (orderRepository.save(orderModel).getStatus().equals("3")){
            jsonObject.put("status", true);
            jsonObject.put("messag", "Successfully Delivered");
            sendNotification("Order Started to delivered",orderModel.getProductName(),"/topics/"+orderModel.getUserId());
            return jsonObject;
        }

        jsonObject.put("status", false);
        jsonObject.put("messag", "something went wrong");
        return jsonObject;
    }

    public Object faildToDeliveredOrder(OrderModel orderModel) {
        JSONObject jsonObject=new JSONObject();

        orderModel.setStatus("0");
        orderModel.setStatusMessage("Faild To Delivered");
        orderRepository.save(orderModel);
        if (orderRepository.save(orderModel).getStatus().equals("0")){
            jsonObject.put("status", true);
            jsonObject.put("messag", "Faild To Delivered");
            sendNotification("Order Successfully Delivered",orderModel.getProductName(),"/topics/"+orderModel.getUserId());
            return jsonObject;
        }

        jsonObject.put("status", false);
        jsonObject.put("messag", "something went wrong");
        return jsonObject;
    }


    public Object cancelOrderBySeller(OrderModel orderModel) {
        JSONObject jsonObject=new JSONObject();

        orderModel.setStatus("0");
        orderModel.setStatusMessage("Cancel by Seller");
        orderRepository.save(orderModel);
        if (orderRepository.save(orderModel).getStatus().equals("0")){
            jsonObject.put("status", true);
            jsonObject.put("messag", "Cancel Successfully");
            sendNotification("Order Cancel "+orderModel.getProductName(),orderModel.getStatusMessage(),"/topics/"+orderModel.getUserId());

            return jsonObject;
        }

        jsonObject.put("status", false);
        jsonObject.put("messag", "something went wrong");
        return jsonObject;
    }
}
