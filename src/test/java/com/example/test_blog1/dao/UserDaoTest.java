package com.example.test_blog1.dao;

import com.example.test_blog1.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import junit.framework.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.List;

public class UserDaoTest {
    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    @Autowired
    UserDao userDao;
    String message = "Robert";
    @Test
    public void testQueryUsersByName()
    {
        System.out.println("Inside testQueryUsersByName()");
        message = "Hi!" + "Robert";


        List<User> res=userDao.queryUsersByName("ru");
        System.out.println(res.size());


    }

}
