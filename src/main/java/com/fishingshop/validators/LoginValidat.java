package com.fishingshop.validators;

import com.fishingshop.exceptions.AuthValidationExcept;

public class LoginValidat {
    public static void validateLogin(String login) {
        if(login == null || login.length() <= 1) {
            throw new AuthValidationExcept("Nieprawidłowy login");
        }
    }

    public static void validatePass(String pass) {
        if(pass == null || pass.length() <= 1) {
            throw new AuthValidationExcept("Nieprawidłowe hasło");
        }
    }
}