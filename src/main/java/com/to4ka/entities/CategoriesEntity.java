package com.to4ka.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.to4ka.auxiliary.EntityJSONInterface;
import org.json.JSONObject;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by User on 2/8/2018.
 */
@Entity
@Table(name = "categories", schema = "to4ka", catalog = "")
public class CategoriesEntity implements EntityJSONInterface {
    private Integer id;
    private String name;
    private Integer parentId;

    private transient Set<ProductsEntity> products;

    public CategoriesEntity() {
        products = new HashSet<ProductsEntity>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
    @Column(name = "PARENT_ID")
    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    @OneToMany
    @JoinTable(
            name = "products",
            joinColumns = @JoinColumn(name = "CATEGORY_ID"),
            inverseJoinColumns = @JoinColumn(name = "ID"))
    public Set<ProductsEntity> getProducts(){
        return this.products;
    }

    @JsonIgnore
    public void setProducts(Set<ProductsEntity> products){
        this.products = products;
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder("Category(");
        builder.append(id != null ? String.format("id=%d ",id):"");
        builder.append(name != null ? String.format("name=%s ",name):"");
        builder.append(parentId != null ? String.format("parentId=%d ",parentId):"");
        builder.append(")");

        return builder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CategoriesEntity that = (CategoriesEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (parentId != null ? !parentId.equals(that.parentId) : that.parentId != null) return false;
        if(products != that.products) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (parentId != null ? parentId.hashCode() : 0);
        return result;
    }

    @Override
    public JSONObject toJSONObject() {
        JSONObject json = new JSONObject();
        json.put("id", id);
        json.put("name", name);
        json.put("parent_id", parentId);

        return json;

//        String jsonString = String.format("{\"id\":%d, \"name\":\"%s\", \"parent_id\":%d}", id, name, parentId);
//        return jsonString;
    }
}
