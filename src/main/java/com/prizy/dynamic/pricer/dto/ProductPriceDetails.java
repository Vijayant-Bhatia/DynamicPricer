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
    
    
}
