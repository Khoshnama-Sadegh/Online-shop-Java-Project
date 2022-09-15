package com.sadegh.data;


import com.sadegh.data.entities.Authorities;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class AuthoritiesDaoImpl implements AuthoritiesDao {

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void saveAuthorities(Authorities authorities) {

        entityManager.persist(authorities);

        entityManager.close();

    }

    @Override
    public Authorities findAuthoritiesByUsername(String username) {
        Authorities authorities= (Authorities) entityManager.createQuery("from Authorities a where a.username :=username")
                .setParameter("username",username).getSingleResult();

        return authorities;
    }
}
