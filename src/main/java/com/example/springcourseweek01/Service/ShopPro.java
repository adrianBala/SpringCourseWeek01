package com.example.springcourseweek01.Service;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


@Service
@Profile("PRO")
@Getter
@Setter
@ConfigurationProperties(prefix = "shop-pro")
public class ShopPro {

    private int vat;
    private int discount;
    private ProductService productService;

    @Autowired
    public ShopPro(ProductService productService) {
        this.productService = productService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void get() {
        productService.generateProducts();
        BigDecimal total = productService.sum();
        BigDecimal drop = productService.calculatePercentage(total, discount);
        BigDecimal withDiscount = total.subtract(drop);
        BigDecimal tax = productService.calculatePercentage(withDiscount, vat);
        System.out.println("Sum: " + total);
        System.out.println("Discount: " + drop);
        System.out.println("With a discount: " + withDiscount);
        System.out.println("Vat: " + tax);
        System.out.println("Total: " + withDiscount.add(tax));
    }
}
