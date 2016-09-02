package com.prizy.dynamic.pricer.service.rule;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.prizy.dynamic.pricer.PrizyConstants;

public interface ProductIdealPriceRule {
    
    BigDecimal calculateIdealPrice(List<BigDecimal> priceList);

    Map<PrizyConstants, BigDecimal> calculatePriceSummary(List<BigDecimal> priceList);
}
