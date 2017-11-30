package com.dhw.greendao.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 建立1个实体类，创建表结构
 * 点击上方 Build - Rebuild Project  构建Project的环境，
 * 之后自动生成表结构 和 当前实体类的各种方法以及 dao包
 */
@Entity
public class FirstBean {
    //id默认不自增
    @Id(autoincrement = true)   //设置主键自增，主键id只能是long类型
    public Long     id;
    public String name;
    public int     age;
    @Generated(hash = 946476083)
    public FirstBean(Long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
    @Generated(hash = 100291509)
    public FirstBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return this.age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}
