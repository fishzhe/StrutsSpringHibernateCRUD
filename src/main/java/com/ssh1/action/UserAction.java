package com.ssh1.action;

import com.opensymphony.xwork2.ActionSupport;
import com.ssh1.dao.UserDao;
import com.ssh1.model.User;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by fishzhe on 5/7/16.
 */
@ParentPackage(value = "json-default")
public class UserAction extends ActionSupport {

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    private List<User> users;

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Autowired
    private UserDao userDao;

    @Action(value = "listUser", results = {
            @Result(name = SUCCESS, location = "/index.jsp"),
            @Result(name = INPUT, location = "/index.jsp")
    })
    public String listUser() {
        users = userDao.listAllUser();
        return SUCCESS;
    }

    @Action(value = "saveUser", results = {
            @Result(name = SUCCESS, type = "redirectAction", location = "listUser"),
            @Result(name = INPUT, location = "/index.jsp")

    })
    public String saveUser() {
        userDao.saveUser(user);
        return SUCCESS;
    }

    @Action(value = "deleteUser", results = {
            @Result(name = SUCCESS, type = "redirectAction", location = "listUser"),
            @Result(name = INPUT, location = "/index.jsp")

    })
    public String deleteUser() {
        userDao.deleteUser(user.getId());
        return SUCCESS;
    }

    public void validate(){
    }
}
