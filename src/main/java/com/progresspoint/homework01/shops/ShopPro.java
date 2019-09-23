package com.progresspoint.homework01.shops;

import com.progresspoint.homework01.bootstraper.ApplicationBootstraper;
import com.progresspoint.homework01.model.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Profile("Pro")
public class ShopPro extends Shop{

    @Value("${shop-resources.vat}")
    private int vat;

    @Value("${shop-resources.discount}")
    private int discount;

    public ShopPro(ApplicationBootstraper bootstraper){
        super(bootstraper);
    }

    @Override
    void displayTotalPriceOfBasket(List<Product> basket){
        System.out.println("Total price + vat - discount: " + basket.stream()
                .mapToInt(x -> x.getPrice()
                        + ((x.getPrice() * vat) / 100)
                        - ((x.getPrice() * discount)/100))
                .sum());
    }

}
