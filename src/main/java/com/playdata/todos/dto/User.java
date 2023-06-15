package com.playdata.todos.dto;

public class User {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private String creatAt;

    public User(Integer id, String username, String password, String name, String creatAt) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.creatAt = creatAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreatAt() {
        return creatAt;
    }

    public void setCreatAt(String creatAt) {
        this.creatAt = creatAt;
    }
}
