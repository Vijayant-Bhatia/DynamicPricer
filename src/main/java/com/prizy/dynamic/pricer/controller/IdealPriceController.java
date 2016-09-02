/**
 * 
 */
package com.prizy.dynamic.pricer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prizy.dynamic.pricer.dto.ProductPriceDetails;
import com.prizy.dynamic.pricer.service.IdealPriceService;

/**
 * @author a579157
 *
 */
@RestController
public class IdealPriceController {

    @Autowired
    IdealPriceService idealPriceService;

    @RequestMapping("/getProductPriceDetails/{barcode}")
    public ProductPriceDetails getIdealPrice(@PathVariable String barcode) {
        return idealPriceService.getProductPriceDetail(barcode);
    }
}