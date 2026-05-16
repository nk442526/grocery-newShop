package com.example.grocery_newShop.controller;

import com.example.grocery_newShop.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    public static List<Product> cart = new ArrayList<>();

    @GetMapping("/")
    public String homePage(Model model) {

        List<Product> productList = new ArrayList<>();

        productList.add(new Product(1, "Rice", 50, "/images/riceimage.png"));
        productList.add(new Product(2, "Milk", 30, "/images/milkimage.png"));
        productList.add(new Product(3, "Sugar", 45, "/images/Sugarimage.png"));
        productList.add(new Product(4, "Oil", 120, "/images/Oilimage.png"));
        productList.add(new Product(5, "Biscuit", 20, "/images/Biscuitimage.png"));

        int cartCount = 0;

        for (Product product : cart) {
            cartCount = cartCount + product.getQuantity();
        }

        model.addAttribute("products", productList);

        model.addAttribute("cartCount", cartCount);

        return "home";
    }

    @GetMapping("/support")
    public String supportPage() {

        return "support";
    }

    @GetMapping("/orders")
    public String orderHistoryPage(Model model) {

        model.addAttribute("orders", cart);

        return "orders";
    }
}