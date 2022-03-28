package com.test.service.serviceImpl;

import com.test.dao.UserDao;
import com.test.entity.User;
import com.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao dao;

    public List<User> getUser() {
        return dao.getUser();
    }
}
