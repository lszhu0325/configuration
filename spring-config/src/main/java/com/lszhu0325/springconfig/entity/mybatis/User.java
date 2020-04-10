package com.lszhu0325.springconfig.entity.mybatis;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Create by lenovo on 2020/4/9
 */
public class User{

    /**
     * 用户id
     */
    private Integer id;

    /**
     * 名字
     */
    private String name;

    /**
     * 密码
     */
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
