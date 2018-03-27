package com.to4ka.entities;

import com.to4ka.auxiliary.EntityJSONInterface;
import org.json.JSONObject;

import javax.persistence.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * Created by User on 2/8/2018.
 */
@Entity
@Table(name = "prices", schema = "to4ka", catalog = "")
public class PricesEntity implements EntityJSONInterface {
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

    @Override
    public JSONObject toJSONObject() {
        JSONObject json = new JSONObject();
        json.put("id", id);
        json.put("name", price);
        json.put("on_date", onDate);
        return json;

//        String jsonString = String.format("{\"id\": %d, \"price\":%f, \"on_date\": \"%d \"}",
//                id, price, new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").format(onDate));
//
//        return jsonString;
    }
}
