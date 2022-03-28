package com.test.dao;


import com.test.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {
    public List<User> getUser();
}
