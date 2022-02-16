package com.example.springcourseweek01.Service;

import com.example.springcourseweek01.Helper.ProductGenerator;
import com.example.springcourseweek01.Model.Product;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
@Getter
@Setter
public class ProductService {

    protected List<Product> bag;

    public ProductService(List<Product> bag) {
        this.bag = bag;
    }

    public void addProduct(Product product) {
        bag.add(product);
    }

    public BigDecimal sum() {
        return bag.stream().map(Product::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void generateProducts() {
        bag.addAll(ProductGenerator.generateRandomProducts(5));
        bag.forEach(product -> System.out.println(String.format("%s, price %.2f", product.getName(), product.getPrice())));
    }

    public BigDecimal calculatePercentage(BigDecimal sum, int rate) {
        return sum.multiply(BigDecimal.valueOf(rate/100.0)).setScale(2, RoundingMode.HALF_UP);
    }

}
