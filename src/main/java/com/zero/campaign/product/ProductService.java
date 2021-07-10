package com.zero.campaign.product;


import com.zero.campaign.product.data.CATEGORY;
import com.zero.campaign.product.data.ProductRepository;
import com.zero.campaign.product.view.Product;
import com.zero.campaign.product.view.VendorProduct;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> createProduct(List<Product> products) {

        Set<com.zero.campaign.product.data.Product> dataProducts = new HashSet<>();

        products.forEach(reqProduct -> {
            com.zero.campaign.product.data.Product dataProduct = new com.zero.campaign.product.data.Product();
            BeanUtils.copyProperties(reqProduct, dataProduct);
            dataProducts.add(dataProduct);
        });

        BeanUtils.copyProperties(productRepository.saveAll(dataProducts), products);

        return products;
    }


    public List<Product> updateProduct(List<Product> products) {
        // custom logic
        return products;
    }

    public Product getProduct(Long id) {
        Product product = new Product();
        BeanUtils.copyProperties(productRepository.findById(id).get(), product);
        return product;
    }

    public List<Product> getProductsByCategory(CATEGORY category) {

        Collection<com.zero.campaign.product.data.Product> dataProducts = productRepository.findProductsByCategory(category);

        List<Product> products = new ArrayList<>();
        dataProducts.forEach(reqProduct -> {
            Product viewProduct = new Product();
            BeanUtils.copyProperties(reqProduct, viewProduct);
            products.add(viewProduct);
        });

        return products;
    }

    public List<Product> getProductsByName(String name) {
        List<Product> products = null;
        // custom logic
        return products;
    }


    public Product getProductById(Long productId) {
        Product product = null;
        // custom logic
        return product;
    }

    public List<VendorProduct> getProductsByVendor(Long vendorId) {
        List<VendorProduct> vendorProduct = null;
        // custom logic
        return vendorProduct;
    }


}
