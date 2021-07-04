package com.zero.campaign.register.view;



public class VendorDetails {

    private String aboutUs;
    private String website;
    private Address address;

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
        return "VendorDetails{" +
                "aboutUs='" + aboutUs + '\'' +
                ", website='" + website + '\'' +
                ", address=" + address +
                '}';
    }
}
