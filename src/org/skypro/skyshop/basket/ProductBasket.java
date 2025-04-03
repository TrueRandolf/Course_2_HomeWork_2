package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {

    Set<Product> innerBasket = new HashSet<>();

    public void addToBasket(Product product) {
        innerBasket.add(product);
    }

    public void printBasket() {
        if (innerBasket.isEmpty()) {
            System.out.println("список пуст");
            return;
        }

        int specialCounter = 0;
        long sumPrice = 0;
        for (Product tail : innerBasket) {
            sumPrice += tail.getPrice();
            if (tail.isSpecial()) {
                specialCounter++;
            }
            System.out.println(tail);
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
        if (innerBasket.isEmpty()) {
            System.out.println("Список пуст");
            return removedProducts;
        }
        Product product;
        Iterator<Product> iterator = innerBasket.iterator();
        while (iterator.hasNext()) {
            product = iterator.next();
            if (product.getName().equals(name)) {
                removedProducts.add(product);
            }
        }
        if (removedProducts.isEmpty()) {
            System.out.println("список пуст");
            return removedProducts;
        }
        for (Product reProduct : removedProducts) {
            innerBasket.remove(reProduct);
        }
        return removedProducts;
    }

}
