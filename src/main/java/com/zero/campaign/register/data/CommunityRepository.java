package com.zero.campaign.register.data;

import com.zero.campaign.main.data.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface CommunityRepository extends JpaRepository<Community, Long> {

}
