package com.zero.campaign.product;

import com.zero.campaign.product.view.CampaignVendorProduct;
import com.zero.campaign.product.view.CampaignVendorProductDetails;
import com.zero.campaign.product.view.VendorProduct;
import com.zero.campaign.product.view.VendorProductDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/inventory")
public class InventoryController {

    @Autowired
    private ProductService productService;


    @PostMapping("/add")
    public List<VendorProduct> addToInventory(@RequestBody List<VendorProduct> vendorProducts)
    {
        return productService.addProductsToVendorInventory(vendorProducts);
    }

    @PutMapping("/update")
    public List<VendorProduct> updateInventory(@RequestBody List<VendorProduct> vendorProducts)
    {
        return productService.updateInventory(vendorProducts);
    }

    @GetMapping("/vendor/{vendorId}")
    public List<VendorProductDetails> getInventory(@PathVariable("vendorId") Long vendorId)
    {
        return productService.getInventory(vendorId);
    }

    @GetMapping("/campaign/{campaignId}/vendor/{vendorId}")
    public List<CampaignVendorProductDetails> getCampaignInventory(@PathVariable("vendorId") Long vendorId, @PathVariable("campaignId") Long campaignId)
    {
        return productService.getCampaignInventory(campaignId,vendorId);
    }

    @PostMapping("/campaign/add")
    public List<CampaignVendorProduct> addInventoryToCampaign(@RequestBody List<CampaignVendorProduct> campaignVendorProducts)
    {
        return productService.addInventoryToCampaign(campaignVendorProducts);
    }

}
