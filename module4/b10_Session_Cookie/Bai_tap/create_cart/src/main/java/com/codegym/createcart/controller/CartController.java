package com.codegym.createcart.controller;

import com.codegym.createcart.model.Cart;
import com.codegym.createcart.model.Product;
import com.codegym.createcart.service.CartService;
import com.codegym.createcart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
;import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private ProductService productService;

  

    @GetMapping("buy/{id}")
    public String addProductToCart(@PathVariable Long id, @SessionAttribute("carts") HashMap<Long, Cart> hashMap, Model model){

        Product product = productService.findById(id);

        if (product != null) {
//            TH chưa có sản phẩm trong giỏ hàng
            if ( !hashMap.containsKey(id) ) {
                Cart item = new Cart();
                item.setProduct(product);
                item.setQuantity(1);
                hashMap.put(id, item);
            } else {
//                TH Sản phẩm đã có trong giỏ hàng
                Cart item = hashMap.get(id);
                item.setQuantity( item.getQuantity() + 1);
                hashMap.put(id, item);
            }
        }
        model.addAttribute("carts", hashMap);
        model.addAttribute("cartNum", hashMap.size());
        model.addAttribute("cartMoney", totalPrice(hashMap));
        return "cart";
    }

    public double totalPrice(HashMap<Long, Cart> cartHashMap) {
        int count = 0;
        for (Map.Entry<Long, Cart> list : cartHashMap.entrySet()) {
            count += Double.parseDouble(list.getValue().getProduct().getNewPrice()) * list.getValue().getQuantity();
        }
        return count;
    }
}
