package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Iterator;
import java.util.LinkedList;

public class ProductBasket {
    LinkedList<Product> innerBasket = new LinkedList<>();

    public void printBasket() {
        if (innerBasket.isEmpty()) {
            System.out.println("в корзине пусто");
            return;
        }
        int specialCounter = 0;
        for (Product prod : innerBasket) {
            if (prod != null) {
                System.out.println(prod);
            }
            if (prod != null && prod.isSpecial()) {
                specialCounter++;
            }
        }
        System.out.println("Итого:<" + getSumPrice() + ">");
        System.out.println("Специальных товаров:<" + specialCounter + ">");
    }

    private long getSumPrice() {
        long summ = 0;
        for (Product prod : innerBasket) {
            if (prod != null) {
                summ += prod.getPrice();
            }
        }
        return summ;
    }

    public void addToBasket(Product product) {
        innerBasket.add(product);
    }

    public void clearBasket() {
        innerBasket.clear();
        System.out.println("Корзина очищена");
    }

    public LinkedList<Product> removeProductFromBasket(String name) {
        LinkedList<Product> removedProducts = new LinkedList<>();
        Iterator<Product> iterator = innerBasket.iterator();
        while (iterator.hasNext()) {
            Product element = iterator.next();
            if (element.getName().equals(name)) {
                removedProducts.add(element);
                iterator.remove();
            }
        }
        if (removedProducts.isEmpty()) {
            System.out.println("Список пуст");
        }
        return removedProducts;
    }
}

