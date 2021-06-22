package com.zero.campaign.product;


import com.zero.campaign.product.view.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {


    public List<Product> updateProduct(List<Product> products)
    {
        // custom logic
        return products;
    }

    public List<Product> getProductsByCampaign(String campaignId)
    {
        List<Product> products= null;
        // custom logic
        return products;
    }

    public Product getProduct(String id)
    {
        Product product= null;
        // custom logic
        return product;
    }
}
