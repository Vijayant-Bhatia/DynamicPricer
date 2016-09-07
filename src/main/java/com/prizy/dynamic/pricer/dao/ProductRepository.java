package com.prizy.dynamic.pricer.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.prizy.dynamic.pricer.domain.Product;

/**
 * @author a579157
 *
 */
@RepositoryRestResource(path = "product")
public interface ProductRepository extends CrudRepository<Product, Long> {

    Product findByBarcode(@Param("barcode")String barcode);

}
