package com.valentinershov.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "test")
public class User {

    private Integer id;
    private String name;
    private Integer age;
    private Boolean isAdmin;
    private Timestamp createdDate;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    @Column
    public String getName() {
        return name;
    }

    @Column
    public Integer getAge() {
        return age;
    }

    @Column
    public Boolean getIsAdmin() {
        return isAdmin;
    }

    @Column
    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setIsAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public void setCreatedDate(Timestamp ts) {
        this.createdDate = ts;
    }
}
