package com.zero.campaign.register.data;

import com.zero.campaign.main.data.Campaign;
import com.zero.campaign.product.data.ProductSize;
import com.zero.campaign.product.data.VendorProduct;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "vendor")
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private VENDOR_TYPE type;
    private long phoneNumber;
    private String email;
    private String imagePath;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vendor_details_id", referencedColumnName = "id")
    private VendorDetails vendorDetails;

    @OneToMany(mappedBy = "vendor", fetch = FetchType.LAZY)
    private Set<VendorProduct> vendorProducts;

    @OneToMany(mappedBy = "vendor", fetch = FetchType.LAZY)
    private Set<Campaign> campaigns;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public VENDOR_TYPE getType() {
        return type;
    }

    public void setType(VENDOR_TYPE type) {
        this.type = type;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public VendorDetails getVendorDetails() {
        return vendorDetails;
    }

    public void setVendorDetails(VendorDetails vendorDetails) {
        this.vendorDetails = vendorDetails;
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

    public Set<Campaign> getCampaigns() {
        return campaigns;
    }

    public void setCampaigns(Set<Campaign> campaigns) {
        this.campaigns = campaigns;
    }
}
