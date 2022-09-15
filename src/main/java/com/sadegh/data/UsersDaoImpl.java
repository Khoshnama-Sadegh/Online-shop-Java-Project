package com.sadegh.data;

import com.sadegh.data.entities.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class UsersDaoImpl implements UsersDao{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void saveUser(Users users) {

        entityManager.persist(users);

        entityManager.close();
    }

    @Override
    public Users findUserByUsername(String username) {
        Users users= (Users) entityManager.createQuery("from Users u where u.username:=username")
                .setParameter("username",username).getSingleResult();

        return users;

    }
}
