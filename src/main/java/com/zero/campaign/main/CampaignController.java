package com.zero.campaign.main;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/campaign")
public class CampaignController {

    @PostMapping("/propose")
    public void proposeCampaign()
    {

    }

    @PutMapping("/confirm")
    public void confirmCampaign(){

    }
    @PutMapping("/start")
    public void startCampaign()
    {

    }
    @PutMapping("/edit")
    public void editCampaign()
    {

    }

    @PutMapping("/close")
    public  void closeCampaign()
    {

    }
}
