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

    private final VendorRepository vendorRepository;
    private final AddressRepository addressRepository;
    private final CommunityRepository communityRepository;
    private final CustomerRepository customerRepository;
    private final VendorDetailsRepository vendorDetailsRepository;

    @Autowired
    public RegistrationService(VendorRepository vendorRepository,
                               AddressRepository addressRepository,
                               CommunityRepository communityRepository,
                               CustomerRepository customerRepository,
                               VendorDetailsRepository vendorDetailsRepository) {
        this.vendorRepository = vendorRepository;
        this.addressRepository = addressRepository;
        this.communityRepository = communityRepository;
        this.customerRepository = customerRepository;
        this.vendorDetailsRepository = vendorDetailsRepository;
    }

    public Vendor registerVendor(Vendor vendor) {
        com.zero.campaign.register.data.Vendor dataVendor = new com.zero.campaign.register.data.Vendor();
        com.zero.campaign.register.data.Address dataAddress = new com.zero.campaign.register.data.Address();
        com.zero.campaign.register.data.VendorDetails dataVendorDetails = new com.zero.campaign.register.data.VendorDetails();

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
        VendorDetails viewVendorDetails = new VendorDetails();
        Address vewAddress = new Address();
        Optional<com.zero.campaign.register.data.Vendor> dataVendor = vendorRepository.findById(id);
        BeanUtils.copyProperties(dataVendor.get(), viewVendor);
        BeanUtils.copyProperties(dataVendor.get().getVendorDetails(), viewVendorDetails);
        BeanUtils.copyProperties(dataVendor.get().getVendorDetails().getAddress(), vewAddress);

        viewVendorDetails.setAddress(vewAddress);
        viewVendor.setVendorDetails(viewVendorDetails);
        return viewVendor;
    }


    public VendorDetails getVendorDetailsByVendor(Long id) {

        VendorDetails viewVendorDetails = new VendorDetails();
        Address vewAddress = new Address();
        Optional<com.zero.campaign.register.data.Vendor> dataVendor = vendorRepository.findById(id);
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
