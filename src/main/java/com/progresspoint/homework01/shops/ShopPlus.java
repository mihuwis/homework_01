package com.progresspoint.homework01.shops;

import com.progresspoint.homework01.bootstraper.ApplicationBootstraper;
import com.progresspoint.homework01.model.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Profile("Plus")
public class ShopPlus extends Shop{


    @Value("${shop-resources.vat}")
    private int vat;

    public ShopPlus(ApplicationBootstraper bootstraper){
        super(bootstraper);
    }

    @Override
    void displayTotalPriceOfBasket(List<Product> basket){
        System.out.println("Total price + vat : " + basket.stream()
                .mapToInt(x -> x.getPrice()
                        + ((x.getPrice() * vat) / 100))
                .sum());
    }

}
