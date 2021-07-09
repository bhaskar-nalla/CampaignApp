package com.zero.campaign.product.data;

import com.zero.campaign.register.data.Vendor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "vendor_product")
public class VendorProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "vendor_id")
    private Vendor vendor;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;


    @OneToMany(mappedBy = "vendorProduct")
    private Set<CommunityVendorProduct> communityVendorProducts;

    private Double maxRetailPrice;
    private Double vendorPrice;


    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private String createdBy;
    private String updatedBy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }



    public Double getMaxRetailPrice() {
        return maxRetailPrice;
    }

    public void setMaxRetailPrice(Double maxRetailPrice) {
        this.maxRetailPrice = maxRetailPrice;
    }

    public Double getVendorPrice() {
        return vendorPrice;
    }

    public void setVendorPrice(Double vendorPrice) {
        this.vendorPrice = vendorPrice;
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

    public Set<CommunityVendorProduct> getCommunityVendorProducts() {
        return communityVendorProducts;
    }

    public void setCommunityVendorProducts(Set<CommunityVendorProduct> communityVendorProducts) {
        this.communityVendorProducts = communityVendorProducts;
    }
}
