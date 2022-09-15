package com.sadegh.services;

import com.sadegh.data.entities.Authorities;

public interface AuthoritiesService {
    void addAuthorities(Authorities authorities);

    Authorities findAuthoritiesByUsername(String username);
}
