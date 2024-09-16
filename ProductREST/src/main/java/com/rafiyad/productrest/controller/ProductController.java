package com.rafiyad.productrest.controller;


import com.rafiyad.productrest.model.Product;
import com.rafiyad.productrest.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService service;

    @RequestMapping("/")
    public String display(){
        return "Working Website";
    }


    @GetMapping("/products/{id}")

    public ResponseEntity<Product> getProductByID(@PathVariable int id){
        Product product = service.getProductByID(id);
        if(product != null)
            return new ResponseEntity<>(product, HttpStatus.OK);
        else
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts(){
        return new ResponseEntity<>(service.getAllProducts(),HttpStatus.OK);
    }

    @PostMapping("/products")
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        return new ResponseEntity<>(service.addProduct(product),HttpStatus.CREATED);
    }


    @PutMapping("/products/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable int id, @RequestBody Product product){
        Product product1 = service.getProductByID(id);


        if(product1 !=null){
            product1=service.updateProduct(id,product);
            return new ResponseEntity<>("successfully updated",HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Failed to update", HttpStatus.BAD_REQUEST);
        }
    }



    @DeleteMapping("/products/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id){
        Product product = service.getProductByID(id);

        if(product != null) {
            service.deleteById(id);
            return new ResponseEntity<>("product deleted", HttpStatus.OK);
        }
        else
        return new ResponseEntity<>("failed to delete, product not found",HttpStatus.NOT_FOUND);
    }


}
