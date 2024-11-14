package com.productinventory.controller;

import com.productinventory.entity.Product;
import com.productinventory.service.FileProcessorService;
import com.productinventory.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final FileProcessorService fileProcessorService;

    @PostMapping
    public ResponseEntity<List<Product>> addProduct(@RequestParam(name = "file") MultipartFile file) {
        String content = fileProcessorService.readFileFromRequest(file);
        List<Product> products = fileProcessorService.parseContent(content);
        products.forEach(productService::createProduct);

        return ResponseEntity.ok(products);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }
}
