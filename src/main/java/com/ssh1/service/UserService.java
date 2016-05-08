package com.ssh1.service;

import com.ssh1.model.User;

import java.util.List;

/**
 * Created by fishzhe on 5/8/16.
 */
public interface UserService {
    void saveUser(User user);
    List<User> listAllUser();
    User listUserByName(String name);
    boolean deleteUser(int userId);
}
