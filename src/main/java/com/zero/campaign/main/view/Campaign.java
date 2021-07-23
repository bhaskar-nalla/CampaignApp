package com.zero.campaign.main.view;

import com.zero.campaign.main.CAMPAIGN_STATUS;
import com.zero.campaign.main.data.DELIVERY_SPOT;


import java.time.LocalDateTime;


public class Campaign {


    private Long id;
    private String name;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String imagePath;
    private CAMPAIGN_STATUS status;
    private Long vendorId;
    private Long communityId;

    private Integer discountUpTo;
    private Integer dealCount;
    private DELIVERY_SPOT deliverySpot;

    public Campaign() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public CAMPAIGN_STATUS getStatus() {
        return status;
    }

    public void setStatus(CAMPAIGN_STATUS status) {
        this.status = status;
    }

    public Long getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Long communityId) {
        this.communityId = communityId;
    }

    public Long getVendorId() {
        return vendorId;
    }

    public void setVendorId(Long vendorId) {
        this.vendorId = vendorId;
    }

    public Integer getDiscountUpTo() {
        return discountUpTo;
    }

    public void setDiscountUpTo(Integer discountUpTo) {
        this.discountUpTo = discountUpTo;
    }

    public Integer getDealCount() {
        return dealCount;
    }

    public void setDealCount(Integer dealCount) {
        this.dealCount = dealCount;
    }

    public DELIVERY_SPOT getDeliverySpot() {
        return deliverySpot;
    }

    public void setDeliverySpot(DELIVERY_SPOT deliverySpot) {
        this.deliverySpot = deliverySpot;
    }

    @Override
    public String toString() {
        return "Campaign{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", imagePath='" + imagePath + '\'' +
                ", status=" + status +
                ", vendorId=" + vendorId +
                ", communityId=" + communityId +
                ", discountUpTo=" + discountUpTo +
                ", dealCount=" + dealCount +
                ", deliverySpot=" + deliverySpot +
                '}';
    }
}
