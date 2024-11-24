package com.example.lab5;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@RestController
public class Controller {

    @Cacheable(value = "products", key = "#productId")
    @GetMapping("/products/{productId}")
    public Product getProduct(@PathVariable int productId) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new Product(productId, productId + " name");
    }

    @GetMapping("/image")
    public ResponseEntity<Resource> getImage() {
        ClassPathResource img = new ClassPathResource("amogus.jpg");
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(img);
    }
}