package com.to4ka.entities;

import javax.persistence.*;

/**
 * Created by User on 2/8/2018.
 */
@Entity
@Table(name = "mobile_tokens", schema = "to4ka", catalog = "")
public class MobileTokensEntity {
    private int id;
    private String token;
    private int deviceId;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "TOKEN")
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Basic
    @Column(name = "DEVICE_ID")
    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MobileTokensEntity that = (MobileTokensEntity) o;

        if (id != that.id) return false;
        if (deviceId != that.deviceId) return false;
        if (token != null ? !token.equals(that.token) : that.token != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (token != null ? token.hashCode() : 0);
        result = 31 * result + deviceId;
        return result;
    }
}
