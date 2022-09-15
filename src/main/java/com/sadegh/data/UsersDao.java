package com.sadegh.data;

import com.sadegh.data.entities.Users;

public interface UsersDao {

    void saveUser(Users users);

    Users findUserByUsername(String username);
}
