package com.lszhu0325.springconfig.request.User;

import com.lszhu0325.springconfig.request.CommonRequest;

/**
 * Create by lenovo on 2020/4/9
 */
public class UserRequest extends CommonRequest {

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
