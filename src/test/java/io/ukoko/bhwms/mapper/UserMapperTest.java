package io.ukoko.bhwms.mapper;

import io.ukoko.bhwms.BhWmsApplicationTests;
import io.ukoko.bhwms.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class UserMapperTest extends BhWmsApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void addUser() {

        for (int i = 0; i < 100; i++) {
            User user = new User();
            user.setUserName("测试名称"+i);
            user.setUserNick("测试昵称"+i);
            user.setUserTel("188888888"+i);
            user.setUserEmail("1@1"+i+".com");
            user.setPassword(i+"测试密码"+i);
            user.setIsDelete(i%2==0?0:1);
            user.setSalt("测试盐"+i);
            user.setCreateTime(new Date());
            userMapper.addUser(user);
        }
    }

    @Test
    void deleteUser() {
    }

    @Test
    void updateUser() {
    }

    @Test
    void getUserList() {
    }

    @Test
    void getUser() {
    }
}