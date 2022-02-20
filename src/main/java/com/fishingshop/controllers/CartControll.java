package com.fishingshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.fishingshop.service.ICartServI;
import com.fishingshop.session.SessionObject;

import javax.annotation.Resource;

@Controller
@RequestMapping(value = "/cart")
public class CartControll {

    @Autowired
    ICartServI cartService;

    @Resource
    SessionObject sessionObject;

    @RequestMapping(value = "/add/{gearId}")
    public String addGearToCart(@PathVariable Integer gearId) {
        this.cartService.addGearToCart(gearId);
        return "redirect:/main";
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String cart(Model model) {
        model.addAttribute("cart",
                this.sessionObject.getCart());
        model.addAttribute("sum", this.sessionObject.getCart().getSum());
        model.addAttribute("logged", this.sessionObject.isLogged());

        return "cart";
    }
}