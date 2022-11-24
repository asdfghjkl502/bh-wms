package io.ukoko.bhwms.service.impl;

import io.ukoko.bhwms.BhWmsApplicationTests;
import io.ukoko.bhwms.entity.User;
import io.ukoko.bhwms.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest extends BhWmsApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    void getRepositoryUser() {
        List<User> users = userService.getRepositoryUser();
        users.forEach(System.out::println);
    }
}