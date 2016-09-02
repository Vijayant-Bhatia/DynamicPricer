package com.prizy.dynamic.pricer.service.rule;

import static com.prizy.dynamic.pricer.constants.PrizyConstants.AVERAGE;
import static com.prizy.dynamic.pricer.constants.PrizyConstants.HIGHEST;
import static com.prizy.dynamic.pricer.constants.PrizyConstants.LOWEST;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.prizy.dynamic.pricer.constants.PrizyConstants;

@Component
public class ProductIdealPriceRuleImpl implements ProductIdealPriceRule {

    @Override
    public Map<PrizyConstants,BigDecimal> calculatePriceSummary(List<BigDecimal> priceList) {
        Map<PrizyConstants, BigDecimal> priceMap = new HashMap<PrizyConstants, BigDecimal>();
        DoubleSummaryStatistics summaryStatistics =
                priceList.stream().mapToDouble(BigDecimal::doubleValue).summaryStatistics();
        BigDecimal sum = BigDecimal.valueOf(summaryStatistics.getSum());
        long divisorNumber = summaryStatistics.getCount();
        BigDecimal averagePrice = sum.divide(new BigDecimal(divisorNumber), 2, RoundingMode.HALF_UP);
        priceMap.put(AVERAGE, averagePrice);
        priceMap.put(HIGHEST, BigDecimal.valueOf(summaryStatistics.getMax()));
        priceMap.put(LOWEST, BigDecimal.valueOf(summaryStatistics.getMin()));
        return priceMap;
    }

    @Override
    public BigDecimal calculateIdealPrice(List<BigDecimal> priceList) {
        if (priceList == null || priceList.isEmpty()) {
            return BigDecimal.ZERO;
        }
        BigDecimal sum = BigDecimal.ZERO;
        int divisorNumber;
        BigDecimal averagePrice = BigDecimal.ZERO;
        if (priceList.size() <= 4) {
            averagePrice = calculatePriceSummary(priceList).get(AVERAGE);
        } else {
            priceList.sort(Comparator.reverseOrder());
            List<BigDecimal> subList = priceList.subList(2, priceList.size() - 2);
            sum = BigDecimal.valueOf(subList.stream().mapToDouble(BigDecimal::doubleValue).sum());
            divisorNumber = subList.size();
            averagePrice = sum.divide(new BigDecimal(divisorNumber), 2, RoundingMode.HALF_UP);
        }
        BigDecimal idealPrice = averagePrice.multiply(new BigDecimal("1.2"));
        return idealPrice.setScale(2, RoundingMode.HALF_UP);
    }


}
