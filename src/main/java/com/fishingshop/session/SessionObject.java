package com.fishingshop.session;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import com.fishingshop.model.Cart;
import com.fishingshop.model.User;

@Component
@SessionScope
public class SessionObject {
    private User user = null;
    final Cart cart = new Cart();

    public boolean isLogged() {
        return this.user != null;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Cart getCart() {
        return cart;
    }
}
