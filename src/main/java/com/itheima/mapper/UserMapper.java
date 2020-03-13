package com.itheima.mapper;

import com.itheima.domain.User;

/**
 * @author hx   <br>
 * @Title: <br>
 * @Package <br>
 * @Description: <br>
 * @date 2020/3/1311:17
 */
public interface UserMapper {

    public User findByName(String name);


}
