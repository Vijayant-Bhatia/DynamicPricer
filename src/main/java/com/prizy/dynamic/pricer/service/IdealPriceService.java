package com.prizy.dynamic.pricer.service;

import com.prizy.dynamic.pricer.dto.ProductPriceDetails;


/**
 * @author a579157
 *
 */
public interface IdealPriceService {
    ProductPriceDetails getProductPriceDetail(String barcode);
}
