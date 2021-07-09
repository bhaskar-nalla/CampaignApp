package com.zero.campaign.product.data;

import com.zero.campaign.main.data.Campaign;
import com.zero.campaign.register.data.Community;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "community_vendor_product")
public class CommunityVendorProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "community_id")
    private Community community;

    @ManyToOne
    @JoinColumn(name = "vendor_product_id")
    private VendorProduct vendorProduct;

    private Integer campaignDiscount;
    private Integer quantity;



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


    public VendorProduct getVendorProduct() {
        return vendorProduct;
    }

    public void setVendorProduct(VendorProduct vendorProduct) {
        this.vendorProduct = vendorProduct;
    }

    public Integer getCampaignDiscount() {
        return campaignDiscount;
    }

    public void setCampaignDiscount(Integer campaignDiscount) {
        this.campaignDiscount = campaignDiscount;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
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

    public Community getCommunity() {
        return community;
    }

    public void setCommunity(Community community) {
        this.community = community;
    }
}
