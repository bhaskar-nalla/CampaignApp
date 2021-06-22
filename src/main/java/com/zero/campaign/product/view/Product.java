package com.zero.campaign.product.view;

import com.zero.campaign.main.data.Campaign;
import java.time.LocalDateTime;


public class Product {

    private long id;
    private String name;
    private String type;
    private long campaignId;


    public long getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(long campaignId) {
        this.campaignId = campaignId;
    }

    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }




}
