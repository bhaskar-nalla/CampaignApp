package com.zero.campaign.main.view;

import com.zero.campaign.main.CAMPAIGN_STATUS;
import com.zero.campaign.register.view.Vendor;

import java.time.LocalDateTime;


public class Campaign {


    private Long id;
    private String name;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String imagePath;
    private CAMPAIGN_STATUS status;
    private String location;
    private Vendor vendor;

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }





    public Campaign() {
    }

    public Campaign(String name, LocalDateTime startTime, LocalDateTime endTime, String imagePath, CAMPAIGN_STATUS status, String location) {
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.imagePath = imagePath;
        this.status = status;
        this.location = location;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Campaign{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", vendorName='" + vendor + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", imagePath='" + imagePath + '\'' +
                ", status=" + status +
                ", location='" + location + '\'' +
                '}';
    }
}
