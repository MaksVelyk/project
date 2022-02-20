package com.fishingshop.service;

import com.fishingshop.model.view.RegisterUser;

public interface IAuthenticationServI {
    void authenticate(String login, String password);
    void register(RegisterUser registerUser);
}
