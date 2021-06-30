package com.zero.campaign.main;

import com.zero.campaign.main.view.Campaign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/campaign")
public class CampaignController {

    @Autowired
    private  CampaignService campaignService;

    @PostMapping("/propose")
    public Campaign proposeCampaign(@RequestBody Campaign campaign)
    {

        return campaign;
    }

    @PutMapping("/confirm/{id}")
    public void confirmCampaign(@PathVariable("id") long id){

    }
    @PutMapping("/start/{id}")
    public void startCampaign(@PathVariable("id") long id)
    {

    }
    @PutMapping("/edit/{id}")
    public void editCampaign(@PathVariable("id") long id)
    {

    }

    @PutMapping("/close/{id}")
    public  void closeCampaign(@PathVariable("id") long id)
    {

    }

    @GetMapping("/vendor/{id}")
    public List<Campaign> getCampaignsByVendor(@PathVariable("id") Long vendorId)
    {
        return campaignService.getCampaignsByVendor(vendorId);
    }
    @GetMapping("/community/{id}")
    public List<Campaign> getCampaignsByCommunity(@PathVariable("id") long communityId)
    {

        return null;
    }
}
