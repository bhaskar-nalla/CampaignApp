package com.zero.campaign.main;

import com.zero.campaign.main.view.Campaign;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/campaign")
public class CampaignController {

    @PostMapping("/propose")
    public Campaign proposeCampaign(@RequestBody Campaign campaign)
    {

        return campaign;
    }

    @PutMapping("/confirm/{id}")
    public void confirmCampaign(@PathParam("id") long id){

    }
    @PutMapping("/start/{id}")
    public void startCampaign(@PathParam("id") long id)
    {

    }
    @PutMapping("/edit/{id}")
    public void editCampaign(@PathParam("id") long id)
    {

    }

    @PutMapping("/close/{id}")
    public  void closeCampaign(@PathParam("id") long id)
    {

    }

    @GetMapping("/vendor/{id}")
    public List<Campaign> getCampaignsByVendor(@PathParam("id") long vendorId)
    {

        return null;
    }
    @GetMapping("/community/{id}")
    public List<Campaign> getCampaignsByCommunity(@PathParam("id") long communityId)
    {

        return null;
    }
}
