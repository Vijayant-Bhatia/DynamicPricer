package com.prizy.dynamic.pricer.service.rule;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.prizy.dynamic.pricer.constants.PrizyConstants;

public class ProductIdealPriceRuleImplTest {

    List<BigDecimal> priceList = new ArrayList<>();
    DoubleSummaryStatistics summaryStatistics = null;
    
    ProductIdealPriceRuleImpl productIdealPriceRule = new ProductIdealPriceRuleImpl();
    private Map<PrizyConstants, BigDecimal> priceMap;
    @Before
    public void setUp() throws Exception {
        priceList.add(new BigDecimal(32.0));
        priceList.add(new BigDecimal(32.0));
        priceList.add(new BigDecimal(342.0));
        priceList.add(new BigDecimal(35.0));
        priceList.add(new BigDecimal(62.0));
        priceList.add(new BigDecimal(37.0));
        summaryStatistics = priceList.stream().mapToDouble(BigDecimal::doubleValue).summaryStatistics();
        priceMap = productIdealPriceRule.calculatePriceSummary(priceList);
    }

    @After
    public void tearDown() throws Exception {
        priceList.removeAll(priceList);
    }

    @Test
    public void testCalculateIdealPrice() throws Exception {
        BigDecimal idealPrice = productIdealPriceRule.calculateIdealPrice(priceList);
        BigDecimal actualIdealPrice = new BigDecimal("43.20").setScale(2, BigDecimal.ROUND_HALF_UP);
        MatcherAssert.assertThat(idealPrice, Matchers.is(actualIdealPrice));
        System.out.println(idealPrice);
    }

    @Test
    public void testCalculateAveragePrice() throws Exception {
        BigDecimal actualAveragePrice = priceMap.get(PrizyConstants.AVERAGE);
        BigDecimal sum = BigDecimal.valueOf(summaryStatistics.getSum());
        long divisorNumber = summaryStatistics.getCount();
        BigDecimal expectedAveragePrice = sum.divide(new BigDecimal(divisorNumber), 2, RoundingMode.HALF_UP);
        MatcherAssert.assertThat(actualAveragePrice, Matchers.is(expectedAveragePrice));
    }

    @Test
    public void testCalculateLowestPrice() throws Exception {
        BigDecimal actualLowestPrice = priceMap.get(PrizyConstants.LOWEST);
        BigDecimal expectedLowestPrice = BigDecimal.valueOf(summaryStatistics.getMin());
        MatcherAssert.assertThat(actualLowestPrice, Matchers.is(expectedLowestPrice));
    }

    @Test
    public void testCalculateHighestPrice() throws Exception {
        BigDecimal actualHighestPrice = priceMap.get(PrizyConstants.HIGHEST);
        BigDecimal expectedHighestPrice = BigDecimal.valueOf(summaryStatistics.getMax());
        MatcherAssert.assertThat(actualHighestPrice, Matchers.is(expectedHighestPrice));
    }

}
