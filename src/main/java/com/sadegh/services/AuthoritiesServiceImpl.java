package com.sadegh.services;

import com.sadegh.data.AuthoritiesDao;
import com.sadegh.data.entities.Authorities;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class AuthoritiesServiceImpl implements AuthoritiesService{

    AuthoritiesDao authoritiesDao;
    @Override
    @Transactional
    public void addAuthorities(Authorities authorities) {

        authoritiesDao.saveAuthorities(authorities);

    }

    @Override
    @Transactional
    public Authorities findAuthoritiesByUsername(String username) {

        return authoritiesDao.findAuthoritiesByUsername(username);
    }
}
