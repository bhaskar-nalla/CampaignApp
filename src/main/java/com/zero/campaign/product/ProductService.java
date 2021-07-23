package com.zero.campaign.product;


import com.zero.campaign.main.data.Campaign;
import com.zero.campaign.product.data.*;
import com.zero.campaign.product.view.CampaignVendorProduct;
import com.zero.campaign.product.view.CampaignVendorProductDetails;
import com.zero.campaign.product.view.Product;
import com.zero.campaign.product.view.VendorProduct;
import com.zero.campaign.product.view.VendorProductDetails;
import com.zero.campaign.register.data.Vendor;
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

    @Autowired
    private CampaignInventoryRepository campaignInventoryRepository;

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


    public Product updateProduct(Product product) {

        Optional<com.zero.campaign.product.data.Product> dataProduct = productRepository.findById(product.getId());
        Product viewProduct = new Product();
        BeanUtils.copyProperties(product, dataProduct.get());
        BeanUtils.copyProperties(productRepository.save(dataProduct.get()), viewProduct);
        return viewProduct;
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


    public List<VendorProduct> addProductsToVendorInventory(List<VendorProduct> vendorProducts) {

        Set<com.zero.campaign.product.data.VendorProduct> dataVendorProducts = new HashSet<>();

        vendorProducts.forEach(reqVendorProduct -> {
            com.zero.campaign.product.data.VendorProduct dataVendorProduct = new com.zero.campaign.product.data.VendorProduct(
                    new com.zero.campaign.product.data.Product(), new HashSet<>(),
                    new Vendor());

            BeanUtils.copyProperties(reqVendorProduct, dataVendorProduct);

            dataVendorProduct.getProduct().setId(reqVendorProduct.getProductId());
            dataVendorProduct.getVendor().setId(reqVendorProduct.getVendorId());

            reqVendorProduct.getPrices().forEach(reqPrice -> {
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

    public List<VendorProductDetails> getInventory(Long vendorId) {
        Collection<com.zero.campaign.product.data.VendorProduct> dataVendorProducts = vendorProductRepository.findProductsByVendor(vendorId);
        List<VendorProductDetails> vendorProducts = new ArrayList<>();

        dataVendorProducts.forEach(reqVendorProduct -> vendorProducts.add(buildInventory(reqVendorProduct)));

        return vendorProducts;
    }


    private VendorProductDetails buildInventory(com.zero.campaign.product.data.VendorProduct dataVendorProduct) {


        VendorProductDetails viewVendorProduct = new VendorProductDetails(new HashSet<>());
        Product viewProduct = new Product();
        BeanUtils.copyProperties(dataVendorProduct, viewVendorProduct);
        BeanUtils.copyProperties(dataVendorProduct.getProduct(), viewProduct);
        viewVendorProduct.setProduct(viewProduct);
        viewVendorProduct.setVendorId(dataVendorProduct.getVendor().getId());
        dataVendorProduct.getPrices().forEach(reqPrice -> {

            com.zero.campaign.product.view.Price viewPrice = new com.zero.campaign.product.view.Price();
            BeanUtils.copyProperties(reqPrice, viewPrice);
            viewVendorProduct.getPrices().add(viewPrice);

        });


        return viewVendorProduct;
    }


    public List<VendorProduct> updateInventory(List<VendorProduct> vendorProducts) {
        //TODO
        return null;
    }

    public List<CampaignVendorProduct> addInventoryToCampaign(List<CampaignVendorProduct> campaignVendorProducts) {
        Set<com.zero.campaign.product.data.CampaignVendorProduct> dataCampaignInventories = new HashSet<>();

        campaignVendorProducts.forEach(reqCampaignVendorProduct -> {
            com.zero.campaign.product.data.CampaignVendorProduct dataCampaignVendorProduct =
                    new com.zero.campaign.product.data.CampaignVendorProduct(new Campaign(), new com.zero.campaign.product.data.VendorProduct());

            BeanUtils.copyProperties(reqCampaignVendorProduct, dataCampaignVendorProduct);

            dataCampaignVendorProduct.getCampaign().setId(reqCampaignVendorProduct.getCampaignId());
            dataCampaignVendorProduct.getVendorProduct().setId(reqCampaignVendorProduct.getVendorProductId());
            dataCampaignInventories.add(dataCampaignVendorProduct);
        });

        BeanUtils.copyProperties(campaignInventoryRepository.saveAll(dataCampaignInventories), campaignVendorProducts);

        return campaignVendorProducts;
    }

    public List<CampaignVendorProductDetails> getCampaignInventory(Long campaignId, Long vendorId) {

        Collection<com.zero.campaign.product.data.CampaignVendorProduct> dataCampaignInventories = campaignInventoryRepository.findCampaignInventory(campaignId, vendorId);
        Collection<com.zero.campaign.product.data.VendorProduct> dataVendorProducts = new ArrayList<>();

        List<CampaignVendorProductDetails> viewCampaignVendorProductDetailsList = new ArrayList<>();

        dataCampaignInventories.forEach(reqVendorProduct -> {
            CampaignVendorProductDetails viewCampaignVendorProductDetails = new CampaignVendorProductDetails();
            BeanUtils.copyProperties(reqVendorProduct,viewCampaignVendorProductDetails);
            viewCampaignVendorProductDetails.setVendorProductDetails(buildInventory(reqVendorProduct.getVendorProduct()));
            viewCampaignVendorProductDetailsList.add(viewCampaignVendorProductDetails);

        });
        return viewCampaignVendorProductDetailsList;
    }


}
