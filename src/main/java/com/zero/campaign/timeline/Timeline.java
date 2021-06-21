package com.zero.campaign.timeline;

import com.zero.campaign.main.view.Campaign;

import java.util.List;

enum TIMELINE_TYPE{
    HOME,
    USER,
    VENDOR

}

public class Timeline {
    private List<Campaign> campaigns;
    private TIMELINE_TYPE type;

    public Timeline() {
    }

    public Timeline(List<Campaign> campaigns, TIMELINE_TYPE type) {
        this.campaigns = campaigns;
        this.type = type;
    }

    public List<Campaign> getCampaigns() {
        return campaigns;
    }

    public void setCampaigns(List<Campaign> campaigns) {
        this.campaigns = campaigns;
    }

    public TIMELINE_TYPE getType() {
        return type;
    }

    public void setType(TIMELINE_TYPE type) {
        this.type = type;
    }


}
