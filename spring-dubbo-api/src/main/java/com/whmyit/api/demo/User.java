package com.whmyit.api.demo;

/**
 * @Author: whmyit@163.com
 * @Description: 用户信息表
 * @Date: Created in 11:49  2018/10/29
 */
public class User {
    private String email;
    private String name;
    private String password;
    private Integer age;

    public User() {
    }

    public User(String email, String name, String password, Integer age) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.age = age;
    }

    public User(String email, String name) {
        this.email = email;
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
