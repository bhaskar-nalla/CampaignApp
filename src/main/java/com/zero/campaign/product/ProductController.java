package com.zero.campaign.product;

import com.zero.campaign.product.view.Product;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/product")
public class ProductController {

    @PostMapping("/create")
    public Product createProduct(@RequestBody Product product)
    {
        // custom logic
        return product;
    }

}
