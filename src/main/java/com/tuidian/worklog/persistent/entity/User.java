package com.tuidian.worklog.persistent.entity;

import javax.persistence.*;
import java.util.Date;

@Entity //告诉JPA这是一个实体类（和数据表映射的类）
@Table(name = "user") //@Table来指定和哪个数据表对应;如果省略默认表名就是user；
public class User {


    private Integer id;
    private String username;
    private String password;
    private String planDesc;
    private String progress;
    private Date createTime;
    private Date updateTime;
    private String state;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "plan_desc")
    public String getPlanDesc() {
        return planDesc;
    }

    public void setPlanDesc(String planDesc) {
        this.planDesc = planDesc;
    }

    @Basic
    @Column(name = "progress")
    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    @Basic
    @Column(name = "create_time")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "update_time")
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Basic
    @Column(name = "state")
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", planDesc='" + planDesc + '\'' +
                ", progress='" + progress + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", state='" + state + '\'' +
                '}';
    }
}
