package com.progresspoint.homework01.shops;

import com.progresspoint.homework01.bootstraper.ApplicationBootstraper;
import com.progresspoint.homework01.model.Product;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.util.ArrayList;
import java.util.List;

public abstract class Shop {

    private final ApplicationBootstraper bootstraper;

    private List<Product> basket;


    public Shop(ApplicationBootstraper bootstraper) {
        this.bootstraper = bootstraper;
        this.basket = new ArrayList<>();
    }

    @EventListener(ApplicationReadyEvent.class)
    public void manageBasket(){
        bootstraper.initializeBasketContent(basket);
        displayBasketContent(basket);
        displayTotalPriceOfBasket(basket);
    }


    private void displayBasketContent(List<Product> basket){
        basket.forEach(x -> System.out.println(x.toString()));
    }

    abstract void displayTotalPriceOfBasket(List<Product> basket);

}
