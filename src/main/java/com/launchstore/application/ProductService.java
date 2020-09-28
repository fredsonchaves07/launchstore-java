package com.launchstore.application;

import com.launchstore.domain.product.Product;
import com.launchstore.domain.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public void saveProduct(Product product) {

        this.validateOldPrice(product);
        this.validateStatus(product);

        productRepository.save(product);
    }

    private void validateOldPrice(Product product){
        if(product.getOldPrice() == null){
            product.setOldPrice(product.getPrice());
        }
    }

    private void validateStatus(Product product){
        if(product.getStatus() == null){
            product.setStatus(1);
        }
    }

    public Product getProductById(Integer id){
        return (Product) productRepository.findAllById(Collections.singleton(id));
    }
}
