package com.zero.campaign.product.data;

import com.zero.campaign.product.data.VendorProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;


@Repository
public interface VendorProductRepository extends JpaRepository<VendorProduct, Long> {
    @Query("SELECT vp FROM VendorProduct vp WHERE vp.vendor.id = :vendorId")
    Collection<VendorProduct> findProductsByVendor(Long vendorId);

}
