package com.progresspoint.homework01.shops;

import com.progresspoint.homework01.model.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
@Profile("Start")
public class ShopStart {

    private List<Product> basket;

    @Value("${shop-resources.vat}")
    private int vat;

    @Value("${shop-resources.discount}")
    private int discount;

    public ShopStart() {
        this.basket = new ArrayList<>();
    }

    public List<Product> addToBasket(Product product){
        basket.add(product);
        return basket;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void manageBasket(){
        initializeBasketContent();
        displayBasketContent(basket);
        System.out.println(getTotalPriceOfBasket(basket));
    }

    private void initializeBasketContent(){
        basket.add(new Product("Egg", new Random().nextInt(250) + 50));
        basket.add(new Product("Bread", new Random().nextInt(250) + 50));
        basket.add(new Product("Milk", new Random().nextInt(250) + 50));
        basket.add(new Product("Apple", new Random().nextInt(250) + 50));
        basket.add(new Product("Juice", new Random().nextInt(250) + 50));
    }


    private void displayBasketContent(List<Product> basket){
        basket.forEach(x -> System.out.println(x.getName() + " : " + x.getPrice()));
    }

    private Integer getTotalPriceOfBasket(List<Product> basket){
        return basket.stream()
                .mapToInt(Product::getPrice)
                .sum();
    }


    public List<Product> getBasket() {
        return basket;
    }

    public void setBasket(List<Product> basket) {
        this.basket = basket;
    }

    public int getVat() {
        return vat;
    }

    public void setVat(int vat) {
        this.vat = vat;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }






}
