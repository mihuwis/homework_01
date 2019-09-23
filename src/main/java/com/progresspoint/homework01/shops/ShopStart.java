package com.progresspoint.homework01.shops;

import com.progresspoint.homework01.bootstraper.ApplicationBootstraper;
import com.progresspoint.homework01.model.Product;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
@Profile("Start")
public class ShopStart extends Shop{


    public ShopStart(ApplicationBootstraper bootstraper) {
        super(bootstraper);
    }

    @Override
    void displayTotalPriceOfBasket(List<Product> basket){
        System.out.println("Total price : " + basket.stream()
                .mapToInt(x -> x.getPrice())
                .sum());
    }



}
