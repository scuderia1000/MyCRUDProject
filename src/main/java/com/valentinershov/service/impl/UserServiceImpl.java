package com.valentinershov.service.impl;

import com.valentinershov.dao.UserDao;
import com.valentinershov.model.User;
import com.valentinershov.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Танюша on 18.05.2016.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Transactional(readOnly = true)
    public List<User> listUsers(Integer offset, Integer maxResults) {
        return userDao.listUsers(offset, maxResults);
    }

    @Transactional(readOnly = true)
    public User getUser(Integer id) {
        return userDao.getUser(id);
    }@Transactional(readOnly = true)

    public User getUserByName(String name) throws Exception {
        return userDao.getUserByName(name);
    }

    @Transactional
    public void deleteUser(Integer id) {
        userDao.deleteUser(id);
    }

    public Long count(){
        return userDao.count();
    }

}
