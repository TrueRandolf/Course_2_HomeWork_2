package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

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
        innerBasket
                .entrySet().stream()
                .flatMap(Map -> Map.getValue().stream())
                .forEach(System.out::println);
        System.out.println("Итого:<" + getSumPrice() + ">");
        System.out.println("Специальных товаров:<" + getSpecialCount() + ">");
    }

    private long getSumPrice() {
        return innerBasket
                .entrySet().stream()
                .flatMap(Map -> Map.getValue().stream())
                .mapToInt(Product::getPrice).sum();
    }

    private long getSpecialCount() {
        return innerBasket
                .entrySet().stream()
                .flatMap(Map -> Map.getValue().stream())
                .filter(Product::isSpecial).count();
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
