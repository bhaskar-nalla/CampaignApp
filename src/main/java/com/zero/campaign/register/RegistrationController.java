package com.zero.campaign.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/register")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @PostMapping("/vendor")
    public void registerVendor()
    {
        registrationService.registerVendor();
    }

    @PostMapping("/community")
    public void registerCommunity()
    {

    }

    @PostMapping("/customer")
    public void registerCustomer()
    {

    }

    @PutMapping("/validate")
    public Boolean validatePassCode()
    {
        return false;
    }



}
