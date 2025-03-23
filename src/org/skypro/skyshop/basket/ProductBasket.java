package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Arrays;

public class ProductBasket {

    private final Product[] innerBasket = new Product[5];

    public void addProductToBasket(Product product) {
        for (int i = 0; i < innerBasket.length; i++) {
            if (innerBasket[i] == null) {
                innerBasket[i] = product;
                return;
            }
        }
        System.out.println("Невозможно добавить продукт");
    }

    public long getSumPrice() {
        long summ = 0;
        for (Product prod : innerBasket) {
            if (prod != null) {
                summ += prod.getPrice();
            }
        }
        return summ;
    }

    public void printBasket() {
        boolean isNotEmpty = false;
        int specialCounter = 0;
        for (Product prod : innerBasket) {
            if (prod != null) {
                System.out.println(prod);
                isNotEmpty = true;
            }
            if (prod != null && prod.isSpecial()) {
                specialCounter++;
            }
        }
        if (isNotEmpty) {
            System.out.println("Итого:<" + getSumPrice() + ">");
            System.out.println("Специальных товаров:<" + specialCounter + ">");
            return;
        }
        System.out.println("в корзине пусто");
    }

    public boolean getIsProductInBasket(Product product) {
        for (Product prod : innerBasket) {
            if (prod != null && prod.equals(product)) {
                return true;
            }
        }
        return false;
    }

    public void clearBasket() {
        Arrays.fill(innerBasket, null);
        System.out.println("Корзина очищена");
    }
}
