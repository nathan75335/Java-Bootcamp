package com.productinventory.service;

import com.productinventory.entity.Product;
import com.productinventory.exception.ProductExistException;
import com.productinventory.exception.ProductNotFoundException;
import com.productinventory.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Product createProduct(Product product) {
        if(productRepository.findByProductCode(product.getProductCode()).isPresent()){
            throw new ProductExistException(String.format("Product with code %s already exist", product.getProductCode()));
        }

        product = productRepository.save(product);
        return product;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(String.format("Product with id %s not found", id)));
    }

    public String deleteProduct(Long id) {
        Product product = getProductById(id);
        productRepository.delete(product);

        return "Product with id " + id + " deleted";
    }

}
