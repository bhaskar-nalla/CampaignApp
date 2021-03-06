package com.zero.campaign.main;

import com.zero.campaign.main.data.CampaignRepository;
import com.zero.campaign.main.view.Campaign;
import com.zero.campaign.main.view.CampaignDetails;
import com.zero.campaign.register.data.Community;
import com.zero.campaign.register.view.Vendor;
import com.zero.campaign.register.view.VendorDetails;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class CampaignService {

    private final CampaignRepository campaignRepository;

    @Autowired
    public CampaignService(CampaignRepository campaignRepository) {
        this.campaignRepository = campaignRepository;
    }

    public Campaign proposeCampaign(Campaign campaign) {
        com.zero.campaign.main.data.Campaign dataCampaign =
                new com.zero.campaign.main.data.Campaign(new com.zero.campaign.register.data.Vendor(), new Community());
        BeanUtils.copyProperties(campaign, dataCampaign);
        dataCampaign.setStatus(CAMPAIGN_STATUS.PROPOSED);
        dataCampaign.getCommunity().setId(campaign.getCommunityId());
        dataCampaign.getVendor().setId(campaign.getVendorId());
        dataCampaign = campaignRepository.save(dataCampaign);
        BeanUtils.copyProperties(dataCampaign, campaign);
        return campaign;
    }

    public void confirmCampaign(Long id) {
        Optional<com.zero.campaign.main.data.Campaign> dataCampaign = campaignRepository.findById(id);
        dataCampaign.get().setStatus(CAMPAIGN_STATUS.CONFIRMED);
        campaignRepository.save(dataCampaign.get());
    }

    public void startCampaign(Long id) {
        Optional<com.zero.campaign.main.data.Campaign> dataCampaign = campaignRepository.findById(id);
        dataCampaign.get().setStatus(CAMPAIGN_STATUS.ACTIVE);
        campaignRepository.save(dataCampaign.get());
    }

    public void closeCampaign(long id) {
        Optional<com.zero.campaign.main.data.Campaign> dataCampaign = campaignRepository.findById(id);
        dataCampaign.get().setStatus(CAMPAIGN_STATUS.CLOSED);
        campaignRepository.save(dataCampaign.get());
    }

    public void cancelCampaign(long id) {
        Optional<com.zero.campaign.main.data.Campaign> dataCampaign = campaignRepository.findById(id);
        dataCampaign.get().setStatus(CAMPAIGN_STATUS.CANCELED);
        campaignRepository.save(dataCampaign.get());
    }

    public void editCampaign(Campaign campaign) {
        Optional<com.zero.campaign.main.data.Campaign> dataCampaign = campaignRepository.findById(campaign.getId());
        BeanUtils.copyProperties(campaign, dataCampaign.get());
        campaignRepository.save(dataCampaign.get());
    }

    public List<Campaign> getCampaignsByVendor(Long vendorId) {
        List<Campaign> viewCampaign = new ArrayList<>();

        Collection<com.zero.campaign.main.data.Campaign> dataCampaign = campaignRepository.findCampaignsByVendorId(vendorId);

        dataCampaign.forEach(campaignRec -> {
            Campaign campaign = new Campaign();
            BeanUtils.copyProperties(campaignRec, campaign);
            campaign.setCommunityId(campaignRec.getCommunity().getId());
            campaign.setVendorId(campaignRec.getVendor().getId());
            viewCampaign.add(campaign);
        });
        return viewCampaign;
    }

    public List<Campaign> getCampaignsByCommunity(Long communityId) {
        List<Campaign> viewCampaign = new ArrayList<>();
        Collection<com.zero.campaign.main.data.Campaign> dataCampaign = campaignRepository.findCampaignsByCommunityId(communityId);

        dataCampaign.forEach(campaignRec -> {
            Campaign campaign = new Campaign();
            BeanUtils.copyProperties(campaignRec, campaign);
            campaign.setCommunityId(campaignRec.getCommunity().getId());
            campaign.setVendorId(campaignRec.getVendor().getId());
            viewCampaign.add(campaign);
        });
        return viewCampaign;
    }

    public Campaign getCampaignById(Long campaignId) {
        Optional<com.zero.campaign.main.data.Campaign> dataCampaign = campaignRepository.findById(campaignId);
        Campaign viewCampaign = new Campaign();
        BeanUtils.copyProperties(dataCampaign.get(), viewCampaign);
        viewCampaign.setCommunityId(dataCampaign.get().getCommunity().getId());
        viewCampaign.setVendorId(dataCampaign.get().getVendor().getId());
        return viewCampaign;
    }

    public CampaignDetails getCampaignDetails(Long campaignId) {
        Optional<com.zero.campaign.main.data.Campaign> dataCampaign = campaignRepository.findById(campaignId);
        CampaignDetails campaignDetails = new CampaignDetails(new Vendor(new VendorDetails()),
                new com.zero.campaign.register.view.Community());
        BeanUtils.copyProperties(dataCampaign.get(), campaignDetails);
        BeanUtils.copyProperties(dataCampaign.get().getVendor(), campaignDetails.getVendor());
        BeanUtils.copyProperties(dataCampaign.get().getVendor().getVendorDetails(), campaignDetails.getVendor().getVendorDetails());
        BeanUtils.copyProperties(dataCampaign.get().getCommunity(), campaignDetails.getCommunity());
        return campaignDetails;
    }
}
