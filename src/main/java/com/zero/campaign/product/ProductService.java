package com.zero.campaign.product;


import com.zero.campaign.product.data.ProductRepository;
import com.zero.campaign.product.data.ProductSize;
import com.zero.campaign.product.view.Product;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> createProduct(List<Product> products) {

        Set<com.zero.campaign.product.data.Product> dataProducts = new HashSet<>();

        products.forEach(reqProduct -> {
            com.zero.campaign.product.data.Product dataProduct = new com.zero.campaign.product.data.Product(new HashSet<>());
            BeanUtils.copyProperties(reqProduct, dataProduct);

            reqProduct.getProductSizes().forEach(reqProductSize -> {
                ProductSize dataProductSize = new ProductSize();
                BeanUtils.copyProperties(reqProductSize, dataProductSize);
                dataProduct.getProductSizes().add(dataProductSize);
            });
            dataProducts.add(dataProduct);
        });

        BeanUtils.copyProperties(productRepository.saveAll(dataProducts), products);

        return products;
    }

    public List<Product> updateProduct(List<Product> products) {
        // custom logic
        return products;
    }

    public List<Product> getProductsByCampaign(String campaignId) {
        List<Product> products = null;
        // custom logic
        return products;
    }

    public Product getProduct(String id) {
        Product product = null;
        // custom logic
        return product;
    }


}
