package com.ssh1.dao;

import com.ssh1.model.User;

import java.util.List;

/**
 * Created by fishzhe on 5/7/16.
 */
public interface UserDao {

    void saveUser(User user);
    List<User> listAllUser();
    User listUserByName(String name);
    boolean deleteUser(int userId);
}
