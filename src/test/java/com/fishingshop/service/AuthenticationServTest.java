package com.fishingshop.service;

import com.fishingshop.configuration.TestConfiguration;
import com.fishingshop.service.impl.AuthenticateServ;
import com.fishingshop.session.SessionObject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {TestConfiguration.class})
public class AuthenticationServTest {

    @Autowired
    AuthenticateServ authenticationService;

    @Autowired
    SessionObject sessionObject;

    @Test
    public void AuthenticationTest() {
        String login = "root";
        String password = "root";

        this.authenticationService.authenticate(login, password);

        Assert.assertTrue(this.sessionObject.isLogged());
    }
}
