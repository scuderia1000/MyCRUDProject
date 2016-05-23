package com.valentinershov.dao;

import com.valentinershov.model.User;

import java.util.List;

public interface UserDao {

    /*
     * CREATE and UPDATE
     */
    public void saveUser(User user); // create and update

    /*
     * READ
     */
    public List<User> listUsers(Integer offset, Integer maxResults);
    public User getUser(Integer id);
    public User getUserByName(String name) throws Exception ;


    /*
     * DELETE
     */
    public void deleteUser(Integer id);

    public Long count();

}
