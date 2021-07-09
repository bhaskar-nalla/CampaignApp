package com.zero.campaign.product.view;

public class ProductSize {

    private Long id;
    private Double size;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "ProductSize{" +
                "id=" + id +
                ", size=" + size +
                '}';
    }
}
