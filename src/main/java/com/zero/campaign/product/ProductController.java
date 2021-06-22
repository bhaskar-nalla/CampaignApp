package com.zero.campaign.product;

import com.zero.campaign.product.view.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/product")
public class ProductController {

    @PostMapping("/create")
    public List<Product> createProduct(@RequestBody List<Product> products)
    {
        // custom logic
        return products;
    }

    @PutMapping("/update")
    public List<Product> updateProduct(@RequestBody List<Product> products)
    {
        // custom logic
        return products;
    }

    @GetMapping("product/{campaignId}")
    public List<Product> getProductsByCampaign(@PathVariable String campaignId)
    {
        List<Product> products= null;
        // custom logic
        return products;
    }

    @GetMapping("product/{id}")
    public Product getProduct(@PathVariable String id)
    {
        Product product= null;
        // custom logic
        return product;
    }







}
