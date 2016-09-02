package com.prizy.dynamic.pricer.service;

import static com.prizy.dynamic.pricer.PrizyConstants.AVERAGE;
import static com.prizy.dynamic.pricer.PrizyConstants.HIGHEST;
import static com.prizy.dynamic.pricer.PrizyConstants.LOWEST;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prizy.dynamic.pricer.PrizyConstants;
import com.prizy.dynamic.pricer.dao.ProductRepository;
import com.prizy.dynamic.pricer.dao.ProductSurveyRepository;
import com.prizy.dynamic.pricer.dto.ProductPriceDetails;
import com.prizy.dynamic.pricer.service.rule.ProductIdealPriceRule;
import com.prizy.dynamic.pricer.service.rule.ProductIdealPriceRuleImpl;

/**
 * @author a579157
 *
 */
@Service
public class IdealPriceServiceImpl implements IdealPriceService {

    @Autowired
    ProductSurveyRepository loaderRepository;

    @Autowired
    ProductRepository productRepository;


    @Override
    public ProductPriceDetails getProductPriceDetail(String barcode) {

        ProductIdealPriceRule rule = new ProductIdealPriceRuleImpl();
        List<BigDecimal> priceList = loaderRepository.getPrice(barcode);

        List<BigDecimal> clonedList = new ArrayList<>(priceList);

        ProductPriceDetails details = new ProductPriceDetails();

        details.setProduct(productRepository.findByBarcode(barcode));
        details.setIdealPrice(rule.calculateIdealPrice(clonedList));
        Map<PrizyConstants, BigDecimal> summary = rule.calculatePriceSummary(priceList);
        details.setAveragePrice(summary.get(AVERAGE));
        details.setLowestPrice(summary.get(LOWEST));
        details.setHighestPrice(summary.get(HIGHEST));

        return details;
    }

}
