package com.prizy.dynamic.pricer.service;

import static com.prizy.dynamic.pricer.constants.PrizyConstants.AVERAGE;
import static com.prizy.dynamic.pricer.constants.PrizyConstants.HIGHEST;
import static com.prizy.dynamic.pricer.constants.PrizyConstants.LOWEST;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prizy.dynamic.pricer.constants.PrizyConstants;
import com.prizy.dynamic.pricer.dao.ProductRepository;
import com.prizy.dynamic.pricer.dao.ProductSurveyRepository;
import com.prizy.dynamic.pricer.dto.ProductPriceDetails;
import com.prizy.dynamic.pricer.exception.NoRuleFoundException;
import com.prizy.dynamic.pricer.service.rule.ProductIdealPriceRule;
import com.prizy.dynamic.pricer.service.rule.nashorn.DynamicNashornInterpreter;

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

    @Autowired
    ProductIdealPriceRule productIdealPriceRule;

    @Autowired
    private DynamicNashornInterpreter interpreter;
    

    @Override
    public ProductPriceDetails getProductPriceDetail(String barcode) {

        List<BigDecimal> priceList = loaderRepository.getPrice(barcode);
        ProductPriceDetails details = new ProductPriceDetails();
        if(priceList.isEmpty()){
            details.setResponse(false);
            details.setMessage("Barcode not available in the Price list");
            return details;
        }

        List<BigDecimal> clonedList = new ArrayList<>(priceList);
        BigDecimal idealPrice = BigDecimal.ZERO;
        try {
            idealPrice = interpreter.interpretProductIdealPriceRule(clonedList);
        } catch(NoRuleFoundException e){
            idealPrice = productIdealPriceRule.calculateIdealPrice(clonedList);
        }
        details.setProduct(productRepository.findByBarcode(barcode));
        details.setIdealPrice(idealPrice);
        Map<PrizyConstants, BigDecimal> summary = productIdealPriceRule.calculatePriceSummary(priceList);
        details.setAveragePrice(summary.get(AVERAGE));
        details.setLowestPrice(summary.get(LOWEST));
        details.setHighestPrice(summary.get(HIGHEST));
        details.setResponse(true);
        details.setMessage("SUCCESS");
        return details;
    }

}
