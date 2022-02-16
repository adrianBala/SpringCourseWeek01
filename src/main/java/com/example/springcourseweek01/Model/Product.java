package com.example.springcourseweek01.Model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Product {

    String name;
    BigDecimal price;

    public Product(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }
}
