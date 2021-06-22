package com.zero.campaign.main;

import com.zero.campaign.main.view.Campaign;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.websocket.server.PathParam;
import java.util.List;

@Service
public class CampaignService {


    public Campaign proposeCampaign(Campaign campaign)
    {

        return campaign;
    }

    public void confirmCampaign(long id){

    }

    public void startCampaign(long id)
    {

    }

    public void editCampaign(long id)
    {

    }


    public  void closeCampaign(long id)
    {

    }

    public List<Campaign> getCampaignsByVendor(long vendorId)
    {

        return null;
    }

    public List<Campaign> getCampaignsByCommunity(long communityId)
    {

        return null;
    }
}
