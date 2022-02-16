package com.example.springcourseweek01.Helper;

import com.example.springcourseweek01.Model.Product;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProductGenerator {
    
    private static final int MIN_PRICE = 50;
    private static final int MAX_PRICE = 350;

    public static List<Product> generateRandomProducts(int numberOfProducts) {
        List<Product> products = new ArrayList<>();
        Product product;
        for(int i =0; i < numberOfProducts; i++) {
            product = new Product(generateName(), generatePrice());
            products.add(product);
        }
        return products;
    }

    private static BigDecimal generatePrice() {
        Random random = new Random();
        double r = random.nextInt(MAX_PRICE - MIN_PRICE) + MIN_PRICE;
        return new BigDecimal(r).setScale(2, RoundingMode.HALF_UP);
    }

    private static String generateName() {
        return String.format("Product%.0f", Math.random() * 1000);
    }
}
