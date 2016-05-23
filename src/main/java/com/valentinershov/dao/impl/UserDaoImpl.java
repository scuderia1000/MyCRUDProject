package com.valentinershov.dao.impl;

import com.valentinershov.dao.UserDao;
import com.valentinershov.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void saveUser(User user) {
        getSession().merge(user);
    }

    public List<User> listUsers(Integer offset, Integer maxResults) {
        return getSession().createCriteria(User.class)
                .setFirstResult(offset != null ? offset : 0)
                .setMaxResults(maxResults != null ? maxResults : 10)
                .list();
    }

    public User getUser(Integer id) {
        return (User) getSession().get(User.class, id);
    }

    public User getUserByName(String name) throws Exception {
        return (User) getSession().createCriteria(User.class)
                .add(Restrictions.like("name", name) ).uniqueResult();
    }

    public void deleteUser(Integer id) {
        User user = getUser(id);
        if (null != user) {
            getSession().delete(user);
        }
    }

    public Long count(){
        return (Long) getSessionFactory().openSession()
                .createCriteria(User.class)
                .setProjection(Projections.rowCount())
                .uniqueResult();
    }

    private Session getSession() {
        Session session = getSessionFactory().getCurrentSession();
        if (session == null) {
            session = getSessionFactory().openSession();
        }
        return session;
    }

    private SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
