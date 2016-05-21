package com.ssh1.service.impl;

import com.ssh1.dao.UserDao;
import com.ssh1.model.User;
import com.ssh1.service.UserService;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Created by fishzhe on 5/8/16.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    public List<User> listAllUser() {
        return userDao.listAllUser();
    }

    public User listUserByName(String name) {
        return userDao.listUserByName(name);
    }

    public boolean deleteUser(int userId) {
        return userDao.deleteUser(userId);
    }

}
