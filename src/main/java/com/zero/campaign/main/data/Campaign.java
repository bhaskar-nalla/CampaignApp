package com.zero.campaign.main.data;

import com.zero.campaign.main.CAMPAIGN_STATUS;
import com.zero.campaign.product.data.CampaignVendorProduct;
import com.zero.campaign.register.data.Community;
import com.zero.campaign.register.data.Customer;
import com.zero.campaign.register.data.Vendor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "campaign")
public class Campaign {

    @Id
    @SequenceGenerator(
            name = "campaign_sequence",
            sequenceName = "campaign_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "campaign_sequence"
    )
    private Long id;

    private String name;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vendor_id", nullable=false)
    private Vendor vendor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "community_id", nullable=false)
    private Community community;

    @OneToMany(mappedBy = "campaign")
    private Set<CampaignVendorProduct> campaignVendorProducts;





    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String imagePath;
    private CAMPAIGN_STATUS status;
    private Integer discountUpTo;
    private Integer dealCount;
    private DELIVERY_SPOT deliverySpot;

    public Campaign(Vendor vendor, Community community) {
        this.vendor = vendor;
        this.community = community;
    }

    public Campaign(){}

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


    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
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

    public Community getCommunity() {
        return community;
    }

    public void setCommunity(Community community) {
        this.community = community;
    }

    public Integer getDiscountUpTo() {
        return discountUpTo;
    }

    public void setDiscountUpTo(Integer discountUpTo) {
        this.discountUpTo = discountUpTo;
    }

    public Set<CampaignVendorProduct> getCampaignVendorProducts() {
        return campaignVendorProducts;
    }

    public void setCampaignVendorProducts(Set<CampaignVendorProduct> campaignVendorProducts) {
        this.campaignVendorProducts = campaignVendorProducts;
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


}
