package com.sadegh.services;

import com.sadegh.data.UsersDao;
import com.sadegh.data.entities.Users;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class UsersServiceImpl implements UsersService {

    private UsersDao usersDao;



    @Override
    @Transactional
    public void addUser(Users users) {
        usersDao.saveUser(users);

    }

    @Override
    @Transactional
    public Users findUserByusername(String username) {
        return usersDao.findUserByUsername(username);
    }
}
