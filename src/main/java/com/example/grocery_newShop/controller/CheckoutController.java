package com.example.grocery_newShop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CheckoutController {

    @GetMapping("/checkout")
    public String checkoutPage() {
        return "checkout";
    }

    @GetMapping("/order-success")
    public String successPage() {

        HomeController.cart.clear();

        return "success";
    }
}