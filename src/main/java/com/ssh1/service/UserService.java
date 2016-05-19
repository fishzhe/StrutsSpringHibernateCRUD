package com.ssh1.service;

import com.ssh1.model.User;

import java.util.List;

/**
 * Created by fishzhe on 5/8/16.
 */
public interface UserService {
    /**
     * @param user
     */
    void saveUser(User user);

    /**
     * @return all users
     */
    List<User> listAllUser();

    /**
     * @param name
     * @return user
     */
    User listUserByName(String name);

    /**
     * @param userId
     * @return true if delete successfully.
     */
    boolean deleteUser(int userId);

}
