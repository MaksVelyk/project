package com.fishingshop.service.impl;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fishingshop.database.IUserDAOI;
import com.fishingshop.exceptions.LoginAlreadyUseExcept;
import com.fishingshop.model.User;
import com.fishingshop.model.view.RegisterUser;
import com.fishingshop.service.IAuthenticationServI;
import com.fishingshop.session.SessionObject;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class AuthenticateServ implements IAuthenticationServI {

    @Autowired
    IUserDAOI userDAO;

    @Resource
    SessionObject sessionObject;

    @Override
    public void authenticate(String login, String password) {
        Optional<User> user = this.userDAO.getUserByLogin(login);

        if(user.isEmpty() ||
                !user.get().getPass().equals(DigestUtils.md5Hex(password))) {
            return;
        }
        this.sessionObject.setUser(user.get());
    }

    @Override
    public void register(RegisterUser registerUser) {
        Optional<User> userBox = this.userDAO.getUserByLogin(registerUser.getLogin());

        if(userBox.isPresent()) {
            throw new LoginAlreadyUseExcept();
        }

        registerUser.setPass(DigestUtils.md5Hex(registerUser.getPass()));

        User user = new User();
        user.setLogin(registerUser.getLogin());
        user.setPass(registerUser.getPass());
        user.setSurname(registerUser.getSurname());
        user.setName(registerUser.getName());

        this.userDAO.addUser(user);
    }
}
