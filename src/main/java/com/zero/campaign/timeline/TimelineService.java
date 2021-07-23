package com.zero.campaign.timeline;

import com.zero.campaign.register.data.CustomerRepository;
import com.zero.campaign.register.view.Customer;
import com.zero.campaign.timeline.view.Timeline;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TimelineService {

    @Autowired
    private CustomerRepository customerRepository;

    public Timeline geUserTimeline(Long userId)
    {
        return null;
    }


    public Timeline getVendorCampaigns(Long vendorId)
    {

        return null;
    }

    public Timeline getCommunityTimeline(Long userId) {

        return null;
    }
}
