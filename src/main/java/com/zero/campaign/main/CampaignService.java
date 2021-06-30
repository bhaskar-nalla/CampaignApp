package com.zero.campaign.main;

import com.zero.campaign.main.data.CampaignRepository;
import com.zero.campaign.main.view.Campaign;
import com.zero.campaign.register.view.Community;
import com.zero.campaign.register.view.Vendor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class CampaignService {

    private final CampaignRepository campaignRepository;

    @Autowired
    public CampaignService(CampaignRepository campaignRepository) {
        this.campaignRepository = campaignRepository;
    }

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

    public List<Campaign> getCampaignsByVendor(Long vendorId)
    {
        List<Campaign> viewCampaign = new ArrayList<>();

        Collection<com.zero.campaign.main.data.Campaign> dataCampaign = campaignRepository.findCampaignsByVendorId(vendorId);

        dataCampaign.forEach(campaignRec->{
            Campaign campaign = new Campaign();
            Vendor vendor = new Vendor();
            BeanUtils.copyProperties(campaignRec,campaign);
            BeanUtils.copyProperties(campaignRec.getVendor(),vendor);
            campaign.setVendor(vendor);
            viewCampaign.add(campaign);
        });
        return viewCampaign;
    }

    public List<Campaign> getCampaignsByCommunity(Long communityId)
    {
        List<Campaign> viewCampaign = new ArrayList<>();
        Community community = new Community();
        Collection<com.zero.campaign.main.data.Campaign> dataCampaign = campaignRepository.findCampaignsByCommunityId(communityId);

        dataCampaign.forEach(campaignRec->{
            Campaign campaign = new Campaign();
            BeanUtils.copyProperties(campaignRec,campaign);
            BeanUtils.copyProperties(campaignRec.getCommunity(),community);
            campaign.setCommunity(community);
            viewCampaign.add(campaign);
        });
        return viewCampaign;

    }
}
