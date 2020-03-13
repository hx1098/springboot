package com.itheima.service;

import com.itheima.domain.User;

/**
 * @author hx   <br>
 * @Title: <br>
 * @Package <br>
 * @Description: <br>
 * @date 2020/3/1311:23
 */
public interface UserService {

    public User findByName(String name);
}
