package com.zero.campaign.product.data;

import com.zero.campaign.main.data.Campaign;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;


@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(nullable = false)
    private String name;
    private String type;
    private CATEGORY category;
    private String imagePath;
    private String description;
    private String measure;


    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private Set<ProductSize> productSizes;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private Set<VendorProduct> vendorProducts;

    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private String createdBy;
    private String updatedBy;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public CATEGORY getCategory() {
        return category;
    }

    public void setCategory(CATEGORY category) {
        this.category = category;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public Set<ProductSize> getProductSizes() {
        return productSizes;
    }

    public void setProductSizes(Set<ProductSize> productSizes) {
        this.productSizes = productSizes;
    }

    public Set<VendorProduct> getVendorProducts() {
        return vendorProducts;
    }

    public void setVendorProducts(Set<VendorProduct> vendorProducts) {
        this.vendorProducts = vendorProducts;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
}
