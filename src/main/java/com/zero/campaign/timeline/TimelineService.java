package com.zero.campaign.timeline;

import com.zero.campaign.main.view.Campaign;
import com.zero.campaign.main.CAMPAIGN_STATUS;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimelineService {


    public Timeline getHomeTimeline()
    {
        return null;
    }


    public Timeline getMyTimeline()
    {
        return null;
    }


    public Timeline getMyCampaigns()
    {
        return new Timeline(List.of(new Campaign("Test Campaign1", "Prakruthi Veg",null,null, CAMPAIGN_STATUS.CONFIRMED, "ACZ"),
                new Campaign("Test Campaign2", "Prakruthi Veg",null,null, CAMPAIGN_STATUS.CONFIRMED, "ACC")),
                TIMELINE_TYPE.HOME);
    }

}
