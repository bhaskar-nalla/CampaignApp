package com.zero.campaign.product;

import com.zero.campaign.product.data.CATEGORY;
import com.zero.campaign.product.view.Product;
import com.zero.campaign.product.view.VendorProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/product")
public class ProductController {

    @Autowired
    private ProductService productService;


    @RequestMapping(value = "/create",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Product> createProduct(@RequestBody List<Product> products)
    {
        return productService.createProduct(products);
    }

    @PutMapping("/update")
    public List<Product> updateProduct(@RequestBody List<Product> products)
    {
        // custom logic
        return products;
    }

    @GetMapping("category/{category}")
    public List<Product> getProductsByCategory(@PathVariable("category") CATEGORY category)
    {

         return productService.getProductsByCategory(category);
    }

    @GetMapping("name/{name}")
    public List<Product> getProductsByName(@PathVariable("name") String name)
    {
        List<Product> products= null;
        // custom logic
        return products;
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long productId)
    {
        return productService.getProduct(productId);
    }

    @GetMapping("vendor/{vendorId}")
    public List<VendorProduct> getProductsByVendor(@PathVariable("vendorId") Long vendorId)
    {
        List<VendorProduct> vendorProduct= null;
        // custom logic
        return vendorProduct;
    }


}
