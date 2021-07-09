package com.zero.campaign.register.data;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String number;
    private String address1;
    private String address2;
    private ADDRESS_TYPE type;
    private String city;
    private String state;
    private long pin;

    @OneToOne(mappedBy = "address", fetch = FetchType.LAZY)
    private VendorDetails vendorDetails;

    @OneToOne(mappedBy = "address", fetch = FetchType.LAZY)
    private Community community;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public ADDRESS_TYPE getType() {
        return type;
    }

    public void setType(ADDRESS_TYPE type) {
        this.type = type;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public long getPin() {
        return pin;
    }

    public void setPin(long pin) {
        this.pin = pin;
    }

    public VendorDetails getVendorDetails() {
        return vendorDetails;
    }

    public void setVendorDetails(VendorDetails vendorDetails) {
        this.vendorDetails = vendorDetails;
    }

    public Community getCommunity() {
        return community;
    }

    public void setCommunity(Community community) {
        this.community = community;
    }
}
