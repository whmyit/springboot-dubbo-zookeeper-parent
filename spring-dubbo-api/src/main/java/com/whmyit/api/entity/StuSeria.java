package com.whmyit.api.entity;

import java.io.IOException;
import java.io.Serializable;

/**
 * @Author: whmyit@163.com
 * @Description: 序列化测试类
 * @Date: Created in 14:56  2018/3/29
 */
public class StuSeria implements Serializable {

    private Integer id;
    private String email;
    private Integer phone;
    // transient 不会被jvm 默认序列化
    // 但是不代表不能序列化  也可以自己完成序列化
    private transient String  name;

    public StuSeria(){

    }
    public StuSeria(Integer id, String email, Integer phone) {
        this.id = id;
        this.email = email;
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StuSeria(Integer id, String email, Integer phone, String name) {
        this.id = id;
        this.email = email;
        this.phone = phone;
        this.name = name;
    }

    @Override
    public String toString() {
        return "StuSeria{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                ", name='" + name + '\'' +
                '}';
    }


    /**
     *  当不想全部序列化的时候，元素包含 transient 的时候
     *  自己序列化
     * @param s
     */
    private void writeObject(java.io.ObjectOutputStream s) throws IOException,ClassNotFoundException{
        s.defaultWriteObject(); //把jvm能默认序列的元素，进行序列
        s.writeObject(name); //自己完成name 的序列化
    }

    /**
     *
     *  自己反序列化
     * @param s
     * @throws java.io.IOException
     * @throws ClassNotFoundException
     */
    private void readObject(java.io.ObjectInputStream s) throws java.io.IOException, ClassNotFoundException {
        s.defaultReadObject();//把jvm能反序列的，进行反序列
        this.name= (String) s.readObject();//自己完成name的反序列操作
    }



}
