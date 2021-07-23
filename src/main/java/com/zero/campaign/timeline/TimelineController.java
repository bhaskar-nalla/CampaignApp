package com.zero.campaign.timeline;

import com.zero.campaign.main.CampaignService;
import com.zero.campaign.register.RegistrationService;
import com.zero.campaign.register.view.Community;
import com.zero.campaign.timeline.view.TIMELINE_TYPE;
import com.zero.campaign.timeline.view.Timeline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(path = "api/v1/timeline")
public class TimelineController {

    @Autowired
    private TimelineService timelineService;
    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private CampaignService campaignService;

    @GetMapping("/home/{customerId}")
    public Timeline getHomeTimeline(@PathVariable("customerId") Long customerId)
    {
        Timeline timeline = new Timeline();
        //TODO - review later if these calls to moved to other class
        Community viewCommunity = registrationService.getCustomerCommunity(customerId);
        timeline.setCampaigns(campaignService.getCampaignsByCommunity(viewCommunity.getId()));
        timeline.setType(TIMELINE_TYPE.COMMUNITY);

        return timeline;
    }

    @GetMapping("/user/{userId}")
    public Timeline geUserTimeline(@PathVariable("userId") Long userId)
    {
         return timelineService.geUserTimeline(userId);
    }



    @GetMapping("/vendor/{vendorId}")
    public Timeline getMyCampaigns(@PathVariable("vendorId") Long vendorId)
    {
        return timelineService.getVendorCampaigns(vendorId);
    }

}
