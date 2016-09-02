package com.prizy.dynamic.pricer.dao;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.prizy.dynamic.pricer.domain.ProductSurvey;

/**
 * @author a579157
 *
 */
@RepositoryRestResource(path = "productSurvey")
public interface ProductSurveyRepository extends CrudRepository<ProductSurvey, Long> {

    @Query("select pl.price from ProductSurvey pl where pl.product.barcode = ?1")
    List<BigDecimal> getPrice(String barcode);

}
