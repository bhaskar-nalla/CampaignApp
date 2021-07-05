package com.zero.campaign.register;


import com.zero.campaign.register.data.*;
import com.zero.campaign.register.view.Community;
import com.zero.campaign.register.view.Vendor;
import com.zero.campaign.register.view.Address;
import com.zero.campaign.register.view.VendorDetails;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegistrationService {
    @Autowired
    private VendorRepository vendorRepository;
    @Autowired
    private  AddressRepository addressRepository;
    @Autowired
    private  CommunityRepository communityRepository;
    @Autowired
    private  CustomerRepository customerRepository;
    @Autowired
    private  VendorDetailsRepository vendorDetailsRepository;


    public Vendor registerVendor(Vendor vendor) {
        com.zero.campaign.register.data.Vendor dataVendor = new com.zero.campaign.register.data.Vendor();
        com.zero.campaign.register.data.VendorDetails dataVendorDetails = new com.zero.campaign.register.data.VendorDetails();
        com.zero.campaign.register.data.Address dataAddress = new com.zero.campaign.register.data.Address();

        BeanUtils.copyProperties(vendor, dataVendor);
        BeanUtils.copyProperties(vendor.getVendorDetails(), dataVendorDetails);
        BeanUtils.copyProperties(vendor.getVendorDetails().getAddress(), dataAddress);

        dataVendorDetails.setAddress(dataAddress);
        dataVendor.setVendorDetails(dataVendorDetails);

        dataAddress.setType(ADDRESS_TYPE.BUSINESS);
        BeanUtils.copyProperties(vendorRepository.save(dataVendor), vendor);
        return vendor;
    }

    public Vendor getVendor(Long id) {
        Vendor viewVendor = new Vendor();
        Optional<com.zero.campaign.register.data.Vendor> dataVendor = vendorRepository.findById(id);
        BeanUtils.copyProperties(dataVendor.get(), viewVendor);
        return viewVendor;
    }


    public VendorDetails getVendorDetails(Long vendorId) {

        VendorDetails viewVendorDetails = new VendorDetails();
        Address vewAddress = new Address();
        Optional<com.zero.campaign.register.data.Vendor> dataVendor = vendorRepository.findById(vendorId);
        Optional<com.zero.campaign.register.data.VendorDetails> dataVendorDetails = vendorDetailsRepository.findById(dataVendor.get().getId());

        BeanUtils.copyProperties(dataVendor.get().getVendorDetails(), viewVendorDetails);
        BeanUtils.copyProperties(dataVendor.get().getVendorDetails().getAddress(), vewAddress);

        viewVendorDetails.setAddress(vewAddress);

        return viewVendorDetails;
    }

    /*    public Vendor updateVendor(Vendor vendor) {

        return vendor;
    }*/

    public Community registerCommunity(Community community) {
        com.zero.campaign.register.data.Community dataCommunity = new com.zero.campaign.register.data.Community();
        com.zero.campaign.register.data.Address dataAddress = new com.zero.campaign.register.data.Address();
        BeanUtils.copyProperties(community, dataCommunity);
        BeanUtils.copyProperties(community.getAddress(), dataAddress);

        dataAddress.setType(ADDRESS_TYPE.BUSINESS);

        dataCommunity.setAddress(dataAddress);
        BeanUtils.copyProperties(communityRepository.save(dataCommunity), community);
        return community;
    }

    public Community updateCommunity(Community community) {
        return null;
    }


    public void registerUser() {

    }


    public Boolean validatePassCode() {
        return false;
    }


}
