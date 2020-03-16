package com.itheima.service;

import com.itheima.domain.User;
import com.itheima.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author hx   <br>
 * @Title: <br>
 * @Package <br>
 * @Description: <br>
 * @date 2020/3/1311:24
 */
@Service
public class UserServiceImpl  implements  UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByName(String name) {
        User byName = userMapper.findByName(name);
        System.err.println(name);
        return byName;
    }

    @Override
    public User findById(Integer id) {
        return userMapper.findById(id);
    }
}
