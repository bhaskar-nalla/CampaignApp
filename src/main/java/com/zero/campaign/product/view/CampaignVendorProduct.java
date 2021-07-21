package com.zero.campaign.product.view;

public class CampaignVendorProduct {

    private Long id;
    private Long campaignId;
    private Long vendorProductId;

    private Integer communityDiscount;
    private Integer quantity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(Long campaignId) {
        this.campaignId = campaignId;
    }

    public Long getVendorProductId() {
        return vendorProductId;
    }

    public void setVendorProductId(Long vendorProductId) {
        this.vendorProductId = vendorProductId;
    }

    public Integer getCommunityDiscount() {
        return communityDiscount;
    }

    public void setCommunityDiscount(Integer communityDiscount) {
        this.communityDiscount = communityDiscount;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
