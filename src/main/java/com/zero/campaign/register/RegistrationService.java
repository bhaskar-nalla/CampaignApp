package com.zero.campaign.register;



import com.zero.campaign.register.data.*;
import com.zero.campaign.register.view.Address;
import com.zero.campaign.register.view.Community;
import com.zero.campaign.register.view.Customer;
import com.zero.campaign.register.view.Vendor;
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
    private AddressRepository addressRepository;
    @Autowired
    private CommunityRepository communityRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private VendorDetailsRepository vendorDetailsRepository;



    public Vendor registerVendor(Vendor vendor) {
        com.zero.campaign.register.data.Vendor dataVendor = new com.zero.campaign.register.data.Vendor();
        com.zero.campaign.register.data.VendorDetails dataVendorDetails = new com.zero.campaign.register.data.VendorDetails();
        com.zero.campaign.register.data.Address dataAddress = new com.zero.campaign.register.data.Address();

        BeanUtils.copyProperties(vendor, dataVendor);
        BeanUtils.copyProperties(vendor.getVendorDetails(), dataVendorDetails);
        BeanUtils.copyProperties(vendor.getVendorDetails().getAddress(), dataAddress);

        dataAddress.setType(ADDRESS_TYPE.BUSINESS);
        dataVendorDetails.setAddress(dataAddress);
        dataVendor.setVendorDetails(dataVendorDetails);

        BeanUtils.copyProperties(vendorRepository.save(dataVendor), vendor);
        return vendor;
    }

    public Vendor updateVendor(Vendor vendor) {

        Optional<com.zero.campaign.register.data.Vendor> dataVendor = vendorRepository.findById(vendor.getId());
        Optional<com.zero.campaign.register.data.VendorDetails> dataVendorDetails = vendorDetailsRepository.findById(dataVendor.get().getVendorDetails().getId());
        com.zero.campaign.register.data.Address dataAddress = new com.zero.campaign.register.data.Address();

        BeanUtils.copyProperties(vendor.getVendorDetails().getAddress(), dataAddress);
        dataAddress.setId(dataVendorDetails.get().getAddress().getId());
        dataAddress.setType(dataVendorDetails.get().getAddress().getType());

        BeanUtils.copyProperties(vendor.getVendorDetails(), dataVendorDetails.get());
        BeanUtils.copyProperties(vendor, dataVendor.get());

        dataVendorDetails.get().setAddress(dataAddress);
        dataVendor.get().setVendorDetails(dataVendorDetails.get());

        BeanUtils.copyProperties(vendorRepository.save(dataVendor.get()), vendor);
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


    public Community registerCommunity(Community community) {
        com.zero.campaign.register.data.Community dataCommunity = new com.zero.campaign.register.data.Community(
                new com.zero.campaign.register.data.Address());

        BeanUtils.copyProperties(community, dataCommunity);
        BeanUtils.copyProperties(community.getAddress(), dataCommunity.getAddress());
        dataCommunity.getAddress().setType(ADDRESS_TYPE.BUSINESS);
        BeanUtils.copyProperties(communityRepository.save(dataCommunity), community);

        return community;
    }

    public Community updateCommunity(Community community) {

        Optional<com.zero.campaign.register.data.Community> dataCommunity = communityRepository.findById(community.getId());
        Optional<com.zero.campaign.register.data.Address> dataAddress = addressRepository.findById(dataCommunity.get().getAddress().getId());

        BeanUtils.copyProperties(community.getAddress(), dataAddress.get());
        dataAddress.get().setId(dataCommunity.get().getAddress().getId());

        BeanUtils.copyProperties(community, dataCommunity.get());
        dataCommunity.get().setAddress(dataAddress.get());

        BeanUtils.copyProperties(communityRepository.save(dataCommunity.get()), community);
        return community;
    }

    public Community getCommunity(Long id) {

        Community viewCommunity = new Community(new Address());
        Optional<com.zero.campaign.register.data.Community> dataCommunity = communityRepository.findById(id);

        BeanUtils.copyProperties(dataCommunity.get().getAddress(), viewCommunity.getAddress());
        BeanUtils.copyProperties(dataCommunity.get(), viewCommunity);
        return viewCommunity;
    }

    public Community getCustomerCommunity(Long customerId) {

        Community viewCommunity = new Community();
        Optional<com.zero.campaign.register.data.Customer> dataCustomer = customerRepository.findById(customerId);
        BeanUtils.copyProperties(dataCustomer.get().getCommunity(),viewCommunity);
        return viewCommunity;
    }

    public void registerCustomer(Customer customer) {

        com.zero.campaign.register.data.Customer dataCustomer = new com.zero.campaign.register.data.Customer(new com.zero.campaign.register.data.Community());

        BeanUtils.copyProperties(customer, dataCustomer);
        dataCustomer.getCommunity().setId(customer.getCommunityId());
        customerRepository.save(dataCustomer);

    }

    public void updateCustomer(Customer customer) {
        Optional<com.zero.campaign.register.data.Customer> dataCustomer = customerRepository.findById(customer.getId());

        BeanUtils.copyProperties(customer,dataCustomer.get());
        customerRepository.save(dataCustomer.get());

    }

    public Boolean validatePassCode() {
        return false;
    }



}
