package com.zero.campaign.product.view;

import java.util.Set;


public class VendorProductDetails {

    private Long id;
    private Long vendorId;
    private Product product;
    private Set<Price> prices;

    public VendorProductDetails(Set<Price> prices) {

        this.prices = prices;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVendorId() {
        return vendorId;
    }

    public void setVendorId(Long vendorId) {
        this.vendorId = vendorId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Set<Price> getPrices() {
        return prices;
    }

    public void setPrices(Set<Price> prices) {
        this.prices = prices;
    }
}
