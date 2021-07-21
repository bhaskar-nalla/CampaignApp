package com.zero.campaign.product.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;


@Repository
public interface CampaignInventoryRepository extends JpaRepository<CampaignVendorProduct, Long> {

    @Query("SELECT cvp FROM CampaignVendorProduct cvp WHERE cvp.vendorProduct.vendor.id = :vendorId AND cvp.campaign.id =:campaignId")
    Collection<CampaignVendorProduct> findCampaignInventory(Long campaignId, Long vendorId);
}
