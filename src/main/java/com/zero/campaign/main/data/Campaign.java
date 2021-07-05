package com.zero.campaign.main.data;

import com.zero.campaign.main.CAMPAIGN_STATUS;
import com.zero.campaign.product.data.Product;
import com.zero.campaign.register.data.Community;
import com.zero.campaign.register.data.Vendor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

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
    @Column(nullable = false)
    private Long communityId;

    @Column(nullable = false)
    private Long vendorId;

    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String imagePath;
    private CAMPAIGN_STATUS status;


    @OneToMany(mappedBy = "campaign", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Product> products;

    public Long getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Long communityId) {
        this.communityId = communityId;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
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

    public Long getVendorId() {
        return vendorId;
    }

    public void setVendorId(Long vendorId) {
        this.vendorId = vendorId;
    }
}
