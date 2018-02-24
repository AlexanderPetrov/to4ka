package com.to4ka.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by User on 2/8/2018.
 */
@Entity
@Table(name = "products", schema = "to4ka", catalog = "")
public class ProductsEntity {
    private int id;
    private String name;
    private int currentCount;
    private int notificationCount;
    private String description;
    private String image;
    private int currentPriceId;
    private CategoriesEntity categoriesByCategoryId;


    private Set<SalesEntity> sales = new HashSet<SalesEntity>();
    private Set<PricesEntity> prices = new HashSet<PricesEntity>();

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "CURRENT_COUNT")
    public int getCurrentCount() {
        return currentCount;
    }

    public void setCurrentCount(int currentCount) {
        this.currentCount = currentCount;
    }

    @Basic
    @Column(name = "NOTIFICATION_COUNT")
    public int getNotificationCount() {
        return notificationCount;
    }

    public void setNotificationCount(int notificationCount) {
        this.notificationCount = notificationCount;
    }

    @Basic
    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "IMAGE")
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Basic
    @Column(name = "CURRENT_PRICE_ID")
    public int getCurrentPriceId() {
        return currentPriceId;
    }

    public void setCurrentPriceId(int currentPriceId) {
        this.currentPriceId = currentPriceId;
    }

    @OneToMany
    @JoinTable(name = "prices",
            joinColumns = @JoinColumn(name = "PRODUCT_ID"),
            inverseJoinColumns = @JoinColumn(name = "ID"))
    public Set<PricesEntity> getPrices(){
        return this.prices;
    }

    public void setPrices(Set<PricesEntity> prices){
        this.prices = prices;
    }

    @OneToMany
    @JoinTable(name = "sales",
            joinColumns = @JoinColumn(name = "PRODUCT_ID"),
            inverseJoinColumns = @JoinColumn(name = "ID"))
    public Set<SalesEntity> getSales(){
        return this.sales;
    }

    public void setSales(Set<SalesEntity> sales){
        this.sales = sales;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductsEntity that = (ProductsEntity) o;

        if (id != that.id) return false;
        if (currentCount != that.currentCount) return false;
        if (notificationCount != that.notificationCount) return false;
        if (currentPriceId != that.currentPriceId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (image != null ? !image.equals(that.image) : that.image != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + currentCount;
        result = 31 * result + notificationCount;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (image != null ? image.hashCode() : 0);
        result = 31 * result + currentPriceId;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID", insertable = false, updatable = false, referencedColumnName = "ID", nullable = false)
    public CategoriesEntity getCategoriesByCategoryId() {
        return categoriesByCategoryId;
    }

    public void setCategoriesByCategoryId(CategoriesEntity categoriesByCategoryId) {
        this.categoriesByCategoryId = categoriesByCategoryId;
    }
}
