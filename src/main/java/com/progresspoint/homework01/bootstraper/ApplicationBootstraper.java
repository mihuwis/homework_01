package com.progresspoint.homework01.bootstraper;

import com.progresspoint.homework01.model.Product;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
public class ApplicationBootstraper {

    public void initializeBasketContent(List<Product> basket){
        basket.add(new Product("Egg", new Random().nextInt(250) + 50));
        basket.add(new Product("Bread", new Random().nextInt(250) + 50));
        basket.add(new Product("Milk", new Random().nextInt(250) + 50));
        basket.add(new Product("Apple", new Random().nextInt(250) + 50));
        basket.add(new Product("Juice", new Random().nextInt(250) + 50));
    }
}
