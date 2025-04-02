package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class ProductBasket {

    Map<String, LinkedList<Product>> innerBasket = new HashMap<>();

    public void addToBasket(Product product) {
        if (innerBasket.containsKey(product.getName())) {
            innerBasket.get(product.getName()).add(product);
        } else {
            LinkedList<Product> mapTail = new LinkedList<>();
            mapTail.add(product);
            innerBasket.put(product.getName(), mapTail);
        }
    }

    public void printBasket() {
        if (innerBasket.isEmpty()) {
            System.out.println("в корзине пусто");
            return;
        }
        int specialCounter = 0;
        long sumPrice = 0;
        for (LinkedList<Product> tail : innerBasket.values()) {
            for (Product prod : tail) {
                sumPrice += prod.getPrice();
                if (prod.isSpecial()) {
                    specialCounter++;
                }
                System.out.println(prod);
            }
        }
        System.out.println("Итого:<" + sumPrice + ">");
        System.out.println("Специальных товаров:<" + specialCounter + ">");
    }

    public void clearBasket() {
        innerBasket.clear();
        System.out.println("Корзина очищена");
    }

    public LinkedList<Product> removeProductFromBasket(String name) {
        LinkedList<Product> removedProducts = new LinkedList<>();
        if (!innerBasket.containsKey(name)) {
            System.out.println("Список пуст");
            return removedProducts;
        }
        removedProducts = innerBasket.get(name);
        innerBasket.remove(name);
        return removedProducts;
    }

}

