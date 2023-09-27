package com.example.restapi.controller;

import com.example.restapi.controller.model.ProductID;
import com.example.restapi.model.Product;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class ProductController {
    @PostMapping("/product")
    public ResponseEntity <ProductID> createProduct(@RequestBody final Product product) {
        System.out.println(product);
        ProductID result = new ProductID(UUID.randomUUID().toString());
        return ResponseEntity.status(HttpStatus.CREATED).contentType(MediaType.APPLICATION_JSON).body(result);
    }

    @GetMapping("/product")
    public List<Product> getAllProducts(){
        List<Product> result =new ArrayList<>();

        //String id;
        result.add(new Product("1", "Product1", new BigDecimal( "258.65") ));
        result.add(new Product("2", "Product2", new BigDecimal( "999.44") ));
        result.add(new Product("3", "Product3", new BigDecimal( "646.87") ));

        return result;
    }

    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable final String id){
        System.out.println(id);
        return new Product("888", "A single product", new BigDecimal("432.86"));
    }

    @PatchMapping("/product")
    public void patchProduct(@RequestBody Product product){
        System.out.println(product.getId() +","+ product.getDescription()+","+product.getPrice());
    }

    @DeleteMapping("/product/{id}")
    public void deleteProduct(@PathVariable final String id){
        System.out.println(id);
    }


}
