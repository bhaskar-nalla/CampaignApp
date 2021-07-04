package com.zero.campaign.register.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VendorDetailsRepository extends JpaRepository<VendorDetails, Long> {
}
