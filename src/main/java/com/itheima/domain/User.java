package com.itheima.domain;

/**
 * @author hx   <br>
 * @Title: <br>
 * @Package <br>
 * @Description: <br>
 * @date 2020/3/1311:16
 */
public class User {
    private Integer id;
    private String name;
    private String password;
    private String perms;

    public void setPerms(String perms) {
        this.perms = perms;
    }

    public String getPerms() {
        return perms;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
