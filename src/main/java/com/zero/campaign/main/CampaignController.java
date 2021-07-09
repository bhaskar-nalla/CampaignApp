package com.zero.campaign.main;

import com.zero.campaign.main.view.Campaign;
import com.zero.campaign.main.view.CampaignDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/campaign")
public class CampaignController {

    @Autowired
    private  CampaignService campaignService;

    @PostMapping("/propose")
    public Campaign proposeCampaign(@RequestBody Campaign campaign)
    {
        return campaignService.proposeCampaign(campaign);
    }

    @PutMapping("/confirm/{id}")
    public void confirmCampaign(@PathVariable("id") Long id){
        campaignService.confirmCampaign(id);
    }
    @PutMapping("/start/{id}")
    public void startCampaign(@PathVariable("id") Long id)
    {
        campaignService.startCampaign(id);
    }
    @PutMapping("/edit")
    public void editCampaign(@RequestBody Campaign campaign)
    {
        campaignService.editCampaign(campaign);
    }

    @PutMapping("/close/{id}")
    public  void closeCampaign(@PathVariable("id") long id)
    {
        campaignService.closeCampaign(id);
    }

    @PutMapping("/cancel/{id}")
    public  void cancelCampaign(@PathVariable("id") long id)
    {
        campaignService.cancelCampaign(id);
    }

    @GetMapping("/vendor/{id}")
    public List<Campaign> getCampaignsByVendor(@PathVariable("id") Long vendorId)
    {
        return campaignService.getCampaignsByVendor(vendorId);
    }
    @GetMapping("/community/{id}")
    public List<Campaign> getCampaignsByCommunity(@PathVariable("id") Long communityId)
    {
        return campaignService.getCampaignsByCommunity(communityId);
    }

    @GetMapping("/{id}")
    public Campaign getCampaignByCommunityId(@PathVariable("id") Long campaignId)
    {
        return campaignService.getCampaignById(campaignId);
    }

    @GetMapping("/{id}/details")
    public CampaignDetails getCampaignDetails(@PathVariable("id") Long campaignId)
    {
        return campaignService.getCampaignDetails(campaignId);
    }
}
