package com.zero.campaign.product;


import com.zero.campaign.product.data.CATEGORY;
import com.zero.campaign.product.data.Price;
import com.zero.campaign.product.data.ProductRepository;
import com.zero.campaign.product.view.Product;
import com.zero.campaign.product.view.VendorProduct;
import com.zero.campaign.product.view.VendorProductDetails;
import com.zero.campaign.register.data.Vendor;
import com.zero.campaign.product.data.VendorProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private VendorProductRepository vendorProductRepository;

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
        Collection<com.zero.campaign.product.data.Product> dataProducts = productRepository.findProductsByName(name);

        List<Product> products = new ArrayList<>();
        dataProducts.forEach(reqProduct -> {
            Product viewProduct = new Product();
            BeanUtils.copyProperties(reqProduct, viewProduct);
            products.add(viewProduct);
        });

        return products;
    }


    public List<VendorProduct> createVendorProduct(List<VendorProduct> vendorProducts) {

        Set<com.zero.campaign.product.data.VendorProduct> dataVendorProducts = new HashSet<>();

        vendorProducts.forEach(reqVendorProduct -> {
            com.zero.campaign.product.data.VendorProduct dataVendorProduct = new com.zero.campaign.product.data.VendorProduct(
                    new com.zero.campaign.product.data.Product(),new HashSet<>(),
                    new Vendor());

            BeanUtils.copyProperties(reqVendorProduct, dataVendorProduct);

            dataVendorProduct.getProduct().setId(reqVendorProduct.getProductId());
            dataVendorProduct.getVendor().setId(reqVendorProduct.getVendorId());

            reqVendorProduct.getPrices().forEach(reqPrice ->{
                Price dataPrice = new Price();
                BeanUtils.copyProperties(reqPrice, dataPrice);
                dataPrice.setVendorProduct(dataVendorProduct);
                dataVendorProduct.getPrices().add(dataPrice);
                    });
            dataVendorProducts.add(dataVendorProduct);
        });

        BeanUtils.copyProperties(vendorProductRepository.saveAll(dataVendorProducts), vendorProducts);

        return vendorProducts;
    }

    public List<VendorProductDetails> getProductsByVendor(Long vendorId) {
        Collection<com.zero.campaign.product.data.VendorProduct> dataVendorProducts = vendorProductRepository.findProductsByVendor(vendorId);

        List<VendorProductDetails> vendorProducts = new ArrayList<>();
        dataVendorProducts.forEach(reqVendorProduct -> {
            VendorProductDetails viewVendorProduct = new VendorProductDetails( new HashSet<>());
            Product viewProduct = new Product();
            BeanUtils.copyProperties(reqVendorProduct, viewVendorProduct);
            BeanUtils.copyProperties(reqVendorProduct.getProduct(), viewProduct);
            viewVendorProduct.setProduct(viewProduct);
            reqVendorProduct.getPrices().forEach(reqPrice ->{

                com.zero.campaign.product.view.Price viewPrice = new com.zero.campaign.product.view.Price();
                BeanUtils.copyProperties(reqPrice, viewPrice);
                viewVendorProduct.getPrices().add(viewPrice);

            });

            vendorProducts.add(viewVendorProduct);
        });
        return vendorProducts;
    }



}
