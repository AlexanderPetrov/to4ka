package com.to4ka.entities;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by User on 2/8/2018.
 */
@Entity
@Table(name = "prices", schema = "to4ka", catalog = "")
public class PricesEntity {
    private int id;
    private double price;
    private Timestamp onDate;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "PRICE")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "ON_DATE")
    public Timestamp getOnDate() {
        return onDate;
    }

    public void setOnDate(Timestamp onDate) {
        this.onDate = onDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PricesEntity that = (PricesEntity) o;

        if (id != that.id) return false;
        if (Double.compare(that.price, price) != 0) return false;
        if (onDate != null ? !onDate.equals(that.onDate) : that.onDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (onDate != null ? onDate.hashCode() : 0);
        return result;
    }
}
