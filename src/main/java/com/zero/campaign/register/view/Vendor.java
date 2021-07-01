package com.zero.campaign.register.view;


import com.zero.campaign.register.data.VENDOR_TYPE;

public class Vendor {

    private Long id;
    private String name;
    private VENDOR_TYPE type;
    private long phone_number;
    private String email;
    private Address address;

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

    public long getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(long phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Vendor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", phone_number=" + phone_number +
                ", email='" + email + '\'' +
                ", address=" + address +
                '}';
    }
}
