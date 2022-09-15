package com.sadegh.services;

import com.sadegh.data.entities.Users;

public interface UsersService {

    void addUser(Users users);
    public Users findUserByusername(String username);
}
