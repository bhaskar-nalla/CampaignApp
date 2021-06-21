package com.zero.campaign.main.view;

import com.zero.campaign.main.CAMPAIGN_STATUS;

import java.time.LocalDateTime;


public class Campaign {


    private Long id;
    private String name;
    private String vendorName;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String imagePath;
    private CAMPAIGN_STATUS status;
    private String location;

    public Campaign(String name, String vendorName, LocalDateTime startTime, LocalDateTime endTime, CAMPAIGN_STATUS status, String location) {
        this.name = name;
        this.vendorName = vendorName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
        this.location = location;
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


    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getVendorName() {
        return vendorName;
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
                ", vendorName='" + vendorName + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", imagePath='" + imagePath + '\'' +
                ", status=" + status +
                ", location='" + location + '\'' +
                '}';
    }
}
