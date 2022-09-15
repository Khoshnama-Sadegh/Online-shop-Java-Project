package com.sadegh.data;

import com.sadegh.data.entities.Authorities;

public interface AuthoritiesDao {
    void saveAuthorities(Authorities authorities);

    Authorities findAuthoritiesByUsername(String username);
}
