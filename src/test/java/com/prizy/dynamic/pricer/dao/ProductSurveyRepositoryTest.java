package com.prizy.dynamic.pricer.dao;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.prizy.dynamic.pricer.Application;
import com.prizy.dynamic.pricer.domain.ProductSurvey;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class ProductSurveyRepositoryTest {

    @Autowired
    ProductSurveyRepository repository;
    
    @Test
    public void getProductById(){
        ProductSurvey product = this.repository.findOne(1l);
        assertThat(product.getProductSurveyId(), is(equalTo(1l)));
        assertThat(product.getProductId(), is(equalTo(1l)));
    }

    @Test
    public void saveProductSurvey(){
        ProductSurvey survey = new ProductSurvey();
        survey.setProductId(1l);
        survey.setStoreName("Store 1");
        survey.setPrice(new BigDecimal(33.5));
        survey.setNotes("test survey");

        ProductSurvey savedSurvey = repository.save(survey);

        assertThat(savedSurvey.getProductSurveyId(), notNullValue());
        assertThat(savedSurvey.getProductId(), is(equalTo(survey.getProductId())));
        assertThat(savedSurvey.getStoreName(), is(equalTo(survey.getStoreName())));

    }
}
