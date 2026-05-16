package com.example.grocery_newShop.controller;

import com.example.grocery_newShop.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CartController {

    @GetMapping("/add-to-cart/{id}")
    public String addToCart(@PathVariable int id) {

        for(Product product : HomeController.cart) {

            if(product.getId() == id) {

                product.setQuantity(product.getQuantity() + 1);

                return "redirect:/";
            }
        }

        if(id == 1) {
            HomeController.cart.add(new Product(1,"Rice",50,"/images/riceimage.png"));
        }

        if(id == 2) {
            HomeController.cart.add(new Product(2,"Milk",30,"/images/milkimage.png"));
        }

        if(id == 3) {
            HomeController.cart.add(new Product(3,"Sugar",45,"/images/Sugarimage.png"));
        }

        if(id == 4) {
            HomeController.cart.add(new Product(4,"Oil",120,"/images/Oilimage.png"));
        }

        if(id == 5) {
            HomeController.cart.add(new Product(5,"Biscuit",20,"/images/Biscuitimage.png"));
        }

        return "redirect:/";
    }

    @GetMapping("/increase/{id}")
    public String increaseQuantity(@PathVariable int id) {

        for(Product product : HomeController.cart) {

            if(product.getId() == id) {

                product.setQuantity(product.getQuantity() + 1);

                break;
            }
        }

        return "redirect:/cart";
    }

    @GetMapping("/decrease/{id}")
    public String decreaseQuantity(@PathVariable int id) {

        for(Product product : HomeController.cart) {

            if(product.getId() == id) {

                product.setQuantity(product.getQuantity() - 1);

                if(product.getQuantity() <= 0) {

                    HomeController.cart.remove(product);
                }

                break;
            }
        }

        return "redirect:/cart";
    }

    @GetMapping("/cart")
    public String cartPage(Model model) {

        int total = 0;

        for(Product product : HomeController.cart) {

            total = total + (product.getPrice() * product.getQuantity());
        }

        model.addAttribute("cartItems", HomeController.cart);
        model.addAttribute("total", total);

        return "cart";
    }
}