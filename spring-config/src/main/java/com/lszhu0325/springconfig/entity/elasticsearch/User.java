package com.lszhu0325.springconfig.entity.elasticsearch;

import org.springframework.data.elasticsearch.annotations.Document;

/**
 * Create by lenovo on 2020/4/10
 */
@Document(indexName = "userindex", type = "user")
public class User {

    private static final long serialVersionUID = 1L;

    // 编号
    private Long id;

    // 姓名
    private String name;

    // 描述
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
