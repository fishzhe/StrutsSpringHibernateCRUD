package com.ssh1.dao;

import com.ssh1.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;


import java.util.List;

/**
 * Created by fishzhe on 5/7/16.
 */
@Repository(value = "userDao")
@Transactional
public class UserDaoImpl extends HibernateDaoSupport implements UserDao{

    public void saveUser(User user) {
        getHibernateTemplate().saveOrUpdate(user);
    }

    public List<User> listAllUser() {
        return getHibernateTemplate().loadAll(User.class);
    }

    public User listUserByName(String name) {
        List<User> users = (List<User>) getHibernateTemplate().find("from User u where name=?", name);
        if (users == null || users.size() == 0) {
            return null;
        }
        return users.get(0);
    }

    public boolean deleteUser(int userId) {
        User user = getHibernateTemplate().get(User.class, userId);
        getHibernateTemplate().delete(user);
        return false;
    }
}
