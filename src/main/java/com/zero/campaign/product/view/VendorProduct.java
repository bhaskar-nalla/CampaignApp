package com.zero.campaign.product.view;



import java.util.Set;


public class VendorProduct {

    private Long id;
    private Long vendorId;
    private Long productId;
    private Set<Price> prices;

    public VendorProduct(Set<Price> prices) {
        this.prices = prices;
    }

    public VendorProduct() {
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

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Set<Price> getPrices() {
        return prices;
    }

    public void setPrices(Set<Price> prices) {
        this.prices = prices;
    }
}
