package com.zero.campaign.product;

import com.zero.campaign.product.data.CATEGORY;
import com.zero.campaign.product.view.Product;
import com.zero.campaign.product.view.VendorProduct;
import com.zero.campaign.product.view.VendorProductDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/product")
public class ProductController {

    @Autowired
    private ProductService productService;


    @PostMapping("/create")
    public List<Product> createProduct(@RequestBody List<Product> products)
    {
        return productService.createProduct(products);
    }

    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product)
    {
        return productService.updateProduct(product);
    }

    @GetMapping("category/{category}")
    public List<Product> getProductsByCategory(@PathVariable("category") CATEGORY category)
    {

         return productService.getProductsByCategory(category);
    }

    @GetMapping("name/{name}")
    public List<Product> getProductsByName(@PathVariable("name") String name)
    {
        return productService.getProductsByName(name);
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long productId)
    {
        return productService.getProduct(productId);
    }

}
