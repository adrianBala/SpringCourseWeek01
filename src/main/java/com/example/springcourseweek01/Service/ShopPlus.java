package com.example.springcourseweek01.Service;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@Profile("PLUS")
@Getter
@Setter
@ConfigurationProperties(prefix = "shop-plus")
public class ShopPlus {

    private int vat;
    private ProductService productService;

    public ShopPlus(ProductService productService) {
        this.productService = productService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void get() {
        productService.generateProducts();
        BigDecimal total = productService.sum();
        BigDecimal tax = productService.calculatePercentage(total, vat);
        System.out.println("Sum: " + total);
        System.out.println("Vat: " + tax);
        System.out.println("Total: " + total.add(tax));
    }

}
