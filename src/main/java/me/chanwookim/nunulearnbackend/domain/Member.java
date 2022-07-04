package me.chanwookim.nunulearnbackend.domain;

import javax.persistence.Entity;

@Entity
public class Member extends BaseEntity{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
