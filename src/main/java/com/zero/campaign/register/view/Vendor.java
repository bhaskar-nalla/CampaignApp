package com.zero.campaign.register.view;


import com.zero.campaign.register.data.VENDOR_TYPE;

public class Vendor {

    private Long id;
    private String name;
    private VENDOR_TYPE type;
    private long phoneNumber;
    private String email;
    private String imagePath;
    private String aboutUs;
    private String website;

    private Address address;

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

    public String getAboutUs() {
        return aboutUs;
    }

    public void setAboutUs(String aboutUs) {
        this.aboutUs = aboutUs;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Vendor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", aboutUs='" + aboutUs + '\'' +
                ", website='" + website + '\'' +
                ", address=" + address +
                '}';
    }
}
