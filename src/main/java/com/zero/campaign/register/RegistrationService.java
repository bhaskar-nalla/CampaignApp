package com.zero.campaign.register;


import com.zero.campaign.register.data.AddressRepository;
import com.zero.campaign.register.data.CommunityRepository;
import com.zero.campaign.register.data.CustomerRepository;
import com.zero.campaign.register.data.VendorRepository;
import com.zero.campaign.register.view.Community;
import com.zero.campaign.register.view.Vendor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    private final VendorRepository vendorRepository;
    private final AddressRepository addressRepository;
    private final CommunityRepository communityRepository;
    private final CustomerRepository customerRepository;

    @Autowired
    public RegistrationService(VendorRepository vendorRepository,
                               AddressRepository addressRepository,
                               CommunityRepository communityRepository,
                               CustomerRepository customerRepository)
    {
        this.vendorRepository = vendorRepository;
        this.addressRepository = addressRepository;
        this.communityRepository = communityRepository;
        this.customerRepository = customerRepository;
    }

    public Vendor registerVendor(Vendor vendor)
    {
        com.zero.campaign.register.data.Vendor dataVendor = new com.zero.campaign.register.data.Vendor();
        com.zero.campaign.register.data.Address dataAddress = new com.zero.campaign.register.data.Address();
        BeanUtils.copyProperties(vendor,dataVendor);
        BeanUtils.copyProperties(vendor.getAddress(),dataAddress);
        dataVendor.setAddress(dataAddress);
        BeanUtils.copyProperties(vendorRepository.save(dataVendor), vendor);
        return vendor;
    }


    public Community registerCommunity(Community community)
    {

        return null;
    }


    public void registerUser()
    {

    }


    public Boolean validatePassCode()
    {
        return false;
    }

    public Vendor updateVendor(Vendor vendor) {
        return null;
    }

    public Community updateCommunity(Community community) {
        return null;
    }
}
