package com.example.springcourseweek01.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
@Profile("START")
public class Shop {

    private ProductService productService;

    @Autowired
    public Shop(ProductService productService) {
        this.productService = productService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void get() {
        productService.generateProducts();
        System.out.println("Sum: " + productService.sum());
    }

}
