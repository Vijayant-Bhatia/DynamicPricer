package com.prizy.dynamic.pricer.dao;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.prizy.dynamic.pricer.Application;
import com.prizy.dynamic.pricer.domain.Product;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class ProductRepositoryTest {

    @Autowired
    ProductRepository repository;

    @Test
    public void getProductById(){
        Product product = this.repository.findOne(1l);
        assertThat(product.getProductId(), is(equalTo(1l)));
        assertThat(product.getBarcode(), is(equalTo("B12A333434")));
    }

    @Test
    public void saveProduct(){
        Product product = new Product();
        product.setBarcode("BXXXLL2222L");
        product.setName("Demo Product");

        Product savedProduct = repository.save(product);

        assertThat(savedProduct.getProductId(), notNullValue());
        assertThat(savedProduct.getBarcode(), is(equalTo(product.getBarcode())));
        assertThat(savedProduct.getName(), is(equalTo(product.getName())));

    }
}

