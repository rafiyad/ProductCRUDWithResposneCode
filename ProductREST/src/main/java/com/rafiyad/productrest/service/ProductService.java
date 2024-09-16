package com.rafiyad.productrest.service;


import com.rafiyad.productrest.model.Product;
import com.rafiyad.productrest.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepo repo;


    public List<Product> getAllProducts(){
        return repo.findAll();
    }

    public Product getProductByID(int id){
        return repo.findById(id).orElse(null);
    }

    public Product addProduct(Product product) {
        return repo.save(product);
    }


    public Product updateProduct(int id, Product product) {
        Product existingProduct = repo.findById(id).orElse(null);

        existingProduct.setName(product.getName());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setBand(product.getBand());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setCategory(product.getCategory());
        existingProduct.setReleaseDate(product.getReleaseDate());
        existingProduct.setQuantity(product.getQuantity());

        return repo.save(existingProduct);
    }

    public void deleteById(int id) {
        repo.deleteById(id);
    }
}
