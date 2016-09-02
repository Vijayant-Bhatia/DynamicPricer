/**
 * 
 */
package com.prizy.dynamic.pricer.dto;

import java.math.BigDecimal;

import com.prizy.dynamic.pricer.domain.Product;

/**
 * @author a579157
 *
 */
public class ProductPriceDetails {
    private Product product;
    private BigDecimal idealPrice;
    private BigDecimal averagePrice;
    private BigDecimal lowestPrice;
    private BigDecimal highestPrice;
    private Boolean response;
    private String message;
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    public BigDecimal getIdealPrice() {
        return idealPrice;
    }
    public void setIdealPrice(BigDecimal idealPrice) {
        this.idealPrice = idealPrice;
    }
    public BigDecimal getAveragePrice() {
        return averagePrice;
    }
    public void setAveragePrice(BigDecimal averagePrice) {
        this.averagePrice = averagePrice;
    }
    public BigDecimal getLowestPrice() {
        return lowestPrice;
    }
    public void setLowestPrice(BigDecimal lowestPrice) {
        this.lowestPrice = lowestPrice;
    }
    public BigDecimal getHighestPrice() {
        return highestPrice;
    }
    public void setHighestPrice(BigDecimal highestPrice) {
        this.highestPrice = highestPrice;
    }
    public Boolean getResponse() {
        return response;
    }
    public void setResponse(Boolean response) {
        this.response = response;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    
    
}
