package com.zero.campaign.register;

import com.zero.campaign.register.view.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @PostMapping("/vendor/register")
    public Vendor registerVendor(@RequestBody Vendor vendor)
    {
       return registrationService.registerVendor(vendor);
    }

    @PutMapping("/vendor/update")
    public Vendor updateVendor(@RequestBody Vendor vendor)
    {
        return registrationService.updateVendor(vendor);
    }

    @GetMapping("/vendor/{id}")
    public Vendor getVendor(@PathVariable("id") Long id){
        return  registrationService.getVendor(id);
    }

    @GetMapping("/vendor_details/{id}")
    public VendorDetails getVendorDetails(@PathVariable("id") Long id){
        return  registrationService.getVendorDetails(id);
    }

    @PostMapping("/community/register")
    public Community registerCommunity(@RequestBody Community community)
    {
        return registrationService.registerCommunity(community);
    }

    @PutMapping("/community/update")
    public Community updateCommunity(@RequestBody Community community)
    {
        return registrationService.updateCommunity(community);
    }

    @PostMapping("/customer/register")
    public void registerCustomer()
    {

    }

    @PutMapping("/validate")
    public Boolean validatePassCode()
    {
        return false;
    }



}
