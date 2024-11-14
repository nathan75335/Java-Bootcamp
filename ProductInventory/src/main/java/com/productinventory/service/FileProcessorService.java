package com.productinventory.service;

import com.productinventory.entity.Product;
import com.productinventory.exception.FileNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileProcessorService {
    public String readFileFromRequest(MultipartFile file) {
        StringBuilder content = new StringBuilder();

        if(file == null || file.isEmpty()){
            throw new FileNotFoundException("File is null or empty");
        }

        try(BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {

            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");
            }
        }catch (IOException e){
            throw new IllegalArgumentException("File is not readable");
        }

        return content.toString();
    }

    public List<Product> parseContent(String content){
        List<Product> products = new ArrayList<>();
        String[] lines = content.split("\n");

        for(String line : lines){
            line = line.trim();
            String[] pairs = line.split("\\|");
            String[] keys = new String[pairs.length];
            String[] values = new String[pairs.length];
            Product product = new Product();

            for(int i = 0; i < pairs.length; i++){
                keys[i] = pairs[i].split(":")[0].trim();
                values[i] = pairs[i].split(":")[1].trim();
            }

            for(int i = 0; i < keys.length; i++){
                switch(keys[i].toLowerCase()){
                    case "name":
                        product.setName(values[i]);
                        break;
                    case "price":
                        product.setPrice(new BigDecimal(values[i]));
                        break;
                    case "productcode":
                        product.setProductCode(values[i]);
                        break;
                    case "quantity":
                        product.setQuantity(Integer.parseInt(values[i]));
                        break;
                    default:break;
                }
            }

            products.add(product);
        }

        return products;
    }
}
