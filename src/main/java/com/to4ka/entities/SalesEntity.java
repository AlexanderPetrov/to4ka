package com.to4ka.entities;

import com.to4ka.auxiliary.EntityJSONInterface;
import org.json.JSONObject;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by User on 2/8/2018.
 */
@Entity
@Table(name = "sales", schema = "to4ka", catalog = "")
public class SalesEntity implements EntityJSONInterface{
    private int id;
    private int count;
    private Timestamp saleDate;
    private double summ;
    private double price;
    private UsersEntity user;
    private ProductsEntity product;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "COUNT")
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Basic
    @Column(name = "SALE_DATE")
    public Timestamp getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Timestamp saleDate) {
        this.saleDate = saleDate;
    }

    @Basic
    @Column(name = "SUMM")
    public double getSumm() {
        return summ;
    }

    public void setSumm(double summ) {
        this.summ = summ;
    }

    @Basic
    @Column(name = "PRICE")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SalesEntity that = (SalesEntity) o;

        if (id != that.id) return false;
        if (count != that.count) return false;
        if (Double.compare(that.summ, summ) != 0) return false;
        if (Double.compare(that.price, price) != 0) return false;
        if (saleDate != null ? !saleDate.equals(that.saleDate) : that.saleDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + count;
        result = 31 * result + (saleDate != null ? saleDate.hashCode() : 0);
        temp = Double.doubleToLongBits(summ);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @ManyToOne
    @JoinColumn(insertable = false, updatable = false, referencedColumnName = "ID", nullable = false)
    public ProductsEntity getProduct() {
        return product;
    }

    public void setProduct(ProductsEntity product) {
        this.product = product;
    }

    @ManyToOne
    @JoinColumn(insertable = false, updatable = false, referencedColumnName = "ID", nullable = false)
    public UsersEntity getUser() {
        return user;
    }

    public void setUser(UsersEntity user) {
        this.user = user;
    }

    @Override
    public JSONObject toJSONObject() {
        JSONObject saleJson = new JSONObject();

        saleJson.put("id", getId());
        saleJson.put("product_id", getProduct().getId());
        saleJson.put("count", getCount());
        saleJson.put("summ", getSumm());
        saleJson.put("sale_date", getSaleDate());
        saleJson.put("price", getPrice());
        saleJson.put("user_id", getUser().getId());

        return saleJson;
    }
}
