package com.dhw.greendao.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Transient;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 建立1个实体类，创建表结构
 * 点击上方 Build - Rebuild Project  构建Project的环境，
 * 之后自动生成表结构 和 当前实体类的各种方法以及 dao包
 */
@Entity
public class SecondBean {

    @Id(autoincrement = true)   //设置主键自增，主键id只能是long类型
    public Long id;

    @NotNull                    //@NotNull 表示数据为空时，不能操作，优化数据
    public String username;
    public String password;

    @Transient                  //@Transient 表示约束的字段不会在数据库保存
    public String       des;

    @Generated(hash = 889042892)
    public SecondBean(Long id, @NotNull String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    @Generated(hash = 838846903)
    public SecondBean() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
