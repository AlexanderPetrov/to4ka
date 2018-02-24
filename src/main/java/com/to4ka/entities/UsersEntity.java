package com.to4ka.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by User on 2/8/2018.
 */
@Entity
@Table(name = "users", schema = "to4ka", catalog = "")
public class UsersEntity {
    private int id;
    private String fio;
    private String username;
    private String password;
    private String phone;
    private String comment;
    private byte isVova;

    private Set<TasksEntity> tasks = new HashSet<TasksEntity>();
    private Set<SalesEntity> sales = new HashSet<SalesEntity>();
    private Set<MobileTokensEntity> mobileTokens = new HashSet<MobileTokensEntity>();

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "FIO")
    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    @Basic
    @Column(name = "USERNAME")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "PASSWORD")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "PHONE")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "COMMENT")
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Basic
    @Column(name = "IS_VOVA")
    public byte getIsVova() {
        return isVova;
    }

    public void setIsVova(byte isVova) {
        this.isVova = isVova;
    }

    @OneToMany
    @JoinTable(name = "tasks",
            joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "ID"))
    public Set<TasksEntity> getTasks(){
        return this.tasks;
    }

    public void setTasks(Set<TasksEntity> tasks){
        this.tasks = tasks;
    }

    @OneToMany
    @JoinTable(name = "sales",
            joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "ID"))
    public Set<SalesEntity> getSales(){
        return this.sales;
    }

    public void setSales(Set<SalesEntity> sales){
        this.sales = sales;
    }

    @OneToMany
    @JoinTable(name = "mobile_tokens",
            joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "ID"))
    public Set<MobileTokensEntity> getMobileTokens(){
        return this.mobileTokens;
    }

    public void setMobileTokens(Set<MobileTokensEntity> mobileTokens){
        this.mobileTokens = mobileTokens;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersEntity that = (UsersEntity) o;

        if (id != that.id) return false;
        if (fio != that.fio) return false;
        if (username != that.username) return false;
        if (password != that.password) return false;
        if (phone != that.phone) return false;
        if (comment != that.comment) return false;
        if (isVova != that.isVova) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (fio != null ? fio.hashCode() : 0);
        result = 31 * result + (username != null? username.hashCode() : 0);
        result = 31 * result + (password != null?password.hashCode() : 0);
        result = 31 * result + (phone != null? phone.hashCode() : 0);
        result = 31 * result + (comment != null? comment.hashCode() : 0);
        result = 31 * result + (int) isVova;
        return result;
    }
}
