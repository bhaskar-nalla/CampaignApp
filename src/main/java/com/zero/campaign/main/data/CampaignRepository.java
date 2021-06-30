package com.zero.campaign.main.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface CampaignRepository extends JpaRepository<Campaign, Long> {

    @Query("SELECT c FROM Campaign c WHERE c.community.id = :campaignId")
    Collection<Campaign> findCampaignsByCommunityId(Long campaignId);

    @Query("SELECT c FROM Campaign c WHERE c.vendor.id = :vendorId")
    Collection<Campaign> findCampaignsByVendorId(Long vendorId);
}