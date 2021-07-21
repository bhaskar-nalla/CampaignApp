package com.zero.campaign.product.data;

import com.zero.campaign.register.data.Vendor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"product_id","vendor_id"}, name = "vendor_product_uniqueKey")}
)

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
    private Set<CampaignVendorProduct> campaignInventories;


    @OneToMany(mappedBy = "vendorProduct",cascade = CascadeType.ALL)
    private Set<Price> prices;



    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private String createdBy;
    private String updatedBy;

    public VendorProduct() {

    }

    public VendorProduct(Vendor vendor, Product product) {
        this.vendor = vendor;
        this.product = product;
    }
    public VendorProduct( Product product, Set<Price> prices,Vendor vendor) {
        this.product = product;
        this.prices = prices;
        this.vendor = vendor;
    }
    public VendorProduct(Vendor vendor) {
        this.vendor = vendor;

    }

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

    public Set<CampaignVendorProduct> getCommunityVendorProducts() {
        return campaignInventories;
    }

    public void setCommunityVendorProducts(Set<CampaignVendorProduct> campaignInventories) {
        this.campaignInventories = campaignInventories;
    }

    public Set<Price> getPrices() {
        return prices;
    }

    public void setPrices(Set<Price> prices) {
        this.prices = prices;
    }
}
